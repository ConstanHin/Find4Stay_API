package api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.uploadFile.StorageService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api")
public class FileUploadController {
	
	private final StorageService storageService;
	
	@Autowired
	HotelController hotelController;
	
	
	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}
	
	@GetMapping("/file/{filename}")
//	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		
			Resource file = storageService.loadAsResource(filename);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
					.body(file);
	}
	
	@PostMapping("hoteles/file/add/{id}")
	public void handleFileUpload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {

		storageService.store(file);
		String path = "/api/file/" + file.getOriginalFilename();
		
		hotelController.actualizarImagenHotel(id, path);
		
//		return v;
	}

}
