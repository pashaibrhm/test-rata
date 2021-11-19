package id.rata.testrata.svc;

import java.util.List;

import id.rata.testrata.dto.PembayaranDto;

public interface IPembayaranSvc {
	List<PembayaranDto> findAllPembayaran();
	
	void save(PembayaranDto dto);
	void update(PembayaranDto dto);
	void delete(Integer idPembayaran);
}
