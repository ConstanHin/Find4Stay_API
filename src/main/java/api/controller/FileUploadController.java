package api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.uploadFile.StorageService;


@RestController
@RequestMapping("/api")
public class FileUploadController {
	
	private final StorageService storageService;
	
	
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
	

}
