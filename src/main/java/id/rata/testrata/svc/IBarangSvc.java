package id.rata.testrata.svc;

import java.util.List;

import id.rata.testrata.dto.BarangDto;

public interface IBarangSvc {

	List<BarangDto> findAllBarang();
	BarangDto findBarangByKodeBarang(String kodeBarang);
	
	void save(BarangDto dto);
	void update(BarangDto dto);
	void delete(Integer idBarang);
	
}
