package id.rata.testrata.svc;

import java.util.List;

import id.rata.testrata.dto.ProduksiDto;

public interface IProduksiSvc {

	List<ProduksiDto> findAllProduksi();
	
	void save(ProduksiDto dto);
	void update(ProduksiDto dto);
	void delete(Integer idProduksi);
}
