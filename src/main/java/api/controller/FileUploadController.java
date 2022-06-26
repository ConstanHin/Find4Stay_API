package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import api.uploadFile.StorageService;


@Controller
public class FileUploadController {
	
	private final StorageService storageService;
	
	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}
	
	@PostMapping("/api/file/add")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("Mensaje",
				"Subida del archivo con éxito " + file.getOriginalFilename() + "!");

		return "redirigir:/";
	}

}
