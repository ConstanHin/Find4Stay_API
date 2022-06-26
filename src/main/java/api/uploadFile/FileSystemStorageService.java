package api.uploadFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService{

	private final Path rootDirectorio;
	
	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootDirectorio = Paths.get(properties.getDirectorio());
	}

	
	@Override
	public void store(MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("Error al almacenar el archivo vacío");
		}
		Path rutaDestinoFile = this.rootDirectorio.resolve(
				Paths.get(file.getOriginalFilename())).normalize()
				.toAbsolutePath();
		if(!rutaDestinoFile.getParent().equals(this.rootDirectorio.toAbsolutePath())) {
				throw new StorageException("No se puede almacenar el archivo fuera del directorio actual.");
		}
		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, rutaDestinoFile, StandardCopyOption.REPLACE_EXISTING);
		}
		
	}
		catch (IOException e) {
			throw new StorageException("No se pudo almacenar el archivo", e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
				return Files.walk(this.rootDirectorio, 1)
						.filter(path -> !path.equals(this.rootDirectorio))
						.map(this.rootDirectorio::relativize);
		}
		catch (IOException e) {
			throw new StorageException("Error al leer los archivos almacenados");
		}
	}

	@Override
	public Path load(String filename) {
		return rootDirectorio.resolve(filename);
		
	}

	@Override
	public Resource loadAsResource(String filename) {
			try {
				Path file = load(filename);
				Resource resource = new UrlResource(file.toUri());
				if(resource.exists() || resource.isReadable()) {
					return resource;
				}
				else {
					throw new StorageFileNotFoundException(
							"No se pudo leer el archivo" + filename);
				}
			}
			catch (MalformedURLException e) {
				throw new StorageFileNotFoundException("No se pudo leer el archivo" + filename, e);
			}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootDirectorio.toFile());
		
	}
	
	
	@Override
	public void init() {
		try {
			Files.createDirectories(rootDirectorio);
		}
		catch (IOException e) {
			throw new StorageException("No se pudo inicializar el almacenamiento", e);
		}
	}

}
