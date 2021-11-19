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

import id.rata.testrata.dto.ProduksiDto;
import id.rata.testrata.rest.RestResponse;
import id.rata.testrata.svc.IProduksiSvc;

@RestController
@RequestMapping("/api")
public class ProduksiController {

	@Autowired
	private IProduksiSvc produksiSvc;

	@GetMapping(value = "/produksi")
	public RestResponse findAllProduksi() {
		List<ProduksiDto> listDtos = produksiSvc.findAllProduksi();
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(listDtos);
		
		return res;
	}
	
	@PostMapping(value = "/produksi")
	public RestResponse saveProduksi(@RequestBody ProduksiDto dto) {
		produksiSvc.save(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@PutMapping(value = "/produksi")
	public RestResponse updateProduksi(@RequestBody ProduksiDto dto) {
		produksiSvc.update(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@DeleteMapping(value = "/produksi/{idProduksi}")
	public RestResponse deleteProduksi(@PathVariable Integer idProduksi) {
		produksiSvc.delete(idProduksi);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		
		return res;
	}
}
