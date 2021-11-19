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

import id.rata.testrata.dto.BarangDto;
import id.rata.testrata.rest.RestResponse;
import id.rata.testrata.svc.IBarangSvc;

@RestController
@RequestMapping("/api")
public class BarangController {

	@Autowired
	private IBarangSvc barangSvc;
	
	@GetMapping(value = "/barang")
	public RestResponse findAllBarang() {
		List<BarangDto> listDtos = barangSvc.findAllBarang();
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(listDtos);
		
		return res;
	}
	
	@PostMapping(value = "/barang")
	public RestResponse saveBarang(@RequestBody BarangDto dto) {
		barangSvc.save(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@PutMapping(value = "/barang")
	public RestResponse updateBarang(@RequestBody BarangDto dto) {
		barangSvc.update(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@DeleteMapping(value = "/barang/{idBarang}")
	public RestResponse deleteBarang(@PathVariable Integer idBarang) {
		barangSvc.delete(idBarang);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		
		return res;
	}
}
