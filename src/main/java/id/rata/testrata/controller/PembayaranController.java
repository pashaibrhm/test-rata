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

import id.rata.testrata.dto.PembayaranDto;
import id.rata.testrata.rest.RestResponse;
import id.rata.testrata.svc.IPembayaranSvc;

@RestController
@RequestMapping("/api")
public class PembayaranController {
	
	@Autowired
	private IPembayaranSvc pymtSvc;

	@GetMapping(value = "/pembayaran")
	public RestResponse findAllPembayaran() {
		List<PembayaranDto> listDtos = pymtSvc.findAllPembayaran();
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(listDtos);
		
		return res;
	}
	
	@PostMapping(value = "/pembayaran")
	public RestResponse savePembayaran(@RequestBody PembayaranDto dto) {
		pymtSvc.save(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@PutMapping(value = "/pembayaran")
	public RestResponse updatePembayaran(@RequestBody PembayaranDto dto) {
		pymtSvc.update(dto);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		res.setData(dto);
		
		return res;
	}
	
	@DeleteMapping(value = "/pembayaran/{idPembayaran}")
	public RestResponse deletePembayaran(@PathVariable Integer idPembayaran) {
		pymtSvc.delete(idPembayaran);
		RestResponse res = new RestResponse();
		res.setStatus(200);
		res.setMessage("success");
		
		return res;
	}
}
