package id.rata.testrata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.rata.testrata.dto.PesananDto;
import id.rata.testrata.rest.RestResponse;
import id.rata.testrata.svc.IPesananSvc;

@RestController
@RequestMapping("/api")
public class PesananController {
	
	@Autowired
	private IPesananSvc pesananSvc;
	
	@GetMapping(value = "/pesanan")
	public RestResponse findAllPesanan() {
		List<PesananDto> listDtos = pesananSvc.findAllPesanan();
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(listDtos);
		
		return res;
	}
	
	@PostMapping(value = "/pesanan")
	public RestResponse savePesanan(@RequestBody PesananDto dto) {
		pesananSvc.save(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@PutMapping(value = "/pesanan")
	public RestResponse updatePesanan(@RequestBody PesananDto dto) {
		pesananSvc.update(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@DeleteMapping(value = "/pesanan/{idPesanan}")
	public RestResponse deletePesanan(@PathVariable Integer idPesanan) {
		pesananSvc.delete(idPesanan);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		
		return res;
	}

}
