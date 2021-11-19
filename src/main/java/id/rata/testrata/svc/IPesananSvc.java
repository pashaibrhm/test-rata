package id.rata.testrata.svc;

import java.util.List;

import id.rata.testrata.dto.PesananDto;

public interface IPesananSvc {

	List<PesananDto> findAllPesanan();
	PesananDto findPesananByNoInvoice(String noInvoice);
	
	void save(PesananDto dto);
	void update(PesananDto dto);
	void delete(Integer idPesanan);
}
