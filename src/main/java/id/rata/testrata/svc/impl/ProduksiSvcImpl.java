package id.rata.testrata.svc.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.rata.testrata.dao.IPesananDao;
import id.rata.testrata.dao.IProduksiDao;
import id.rata.testrata.dto.ProduksiDto;
import id.rata.testrata.entity.Produksi;
import id.rata.testrata.svc.IProduksiSvc;

@Transactional
@Service("iProduksiSvc")
public class ProduksiSvcImpl implements IProduksiSvc{
	
	@Autowired
	IProduksiDao produksiDao;
	
	@Autowired
	IPesananDao pesananDao;

	@Override
	public List<ProduksiDto> findAllProduksi() {
		List<ProduksiDto> listDto = new ArrayList<>();
		List<Object[]> listProduksi = produksiDao.findAllProduksi();
		
		for (Object[] obj : listProduksi) {
			ProduksiDto dto = new ProduksiDto();
			
			dto.setIdProduksi((Integer) obj[0]);
			dto.setNoInvoice((String) obj[1]);
			dto.setStatusProduksi((String) obj[2]);
			dto.setTanggalMasuk((Date) obj[3]);
			dto.setTanggalProduksi((Date) obj[4]);
			dto.setTanggalSelesai((Date) obj[5]);
			
			listDto.add(dto);
		}
		
		return listDto;
	}

	@Override
	public void save(ProduksiDto dto) {
		Produksi produksi = new Produksi();
		Integer status = 0;
		
		produksi.setIdPesanan(pesananDao.findPesananByNoInvoice(dto.getNoInvoice()).getIdPesanan());
		
		switch (dto.getStatusProduksi()) {
		case "Desain":
			status = 1;
			break;
		case "Konfirmasi":
			status = 2;
			break;
		case "Cetak":
			status = 3;
			break;
		case "Siap":
			status = 4;
			break;
		case "Kirim":
			status = 5;
			break;
		case "Sampai":
			status = 6;
			break;
		default:
			status = 0;
		}
		
		produksi.setStatusProduksi(status);
		produksi.setTanggalMasuk(dto.getTanggalMasuk());
		produksi.setTanggalProduksi(dto.getTanggalProduksi());
		produksi.setTanggalSelesai(dto.getTanggalSelesai());
		
		produksiDao.save(produksi);
	}

	@Override
	public void update(ProduksiDto dto) {
		Produksi produksi = produksiDao.getById(dto.getIdProduksi());
		Integer status = 0;
		
		produksi.setIdPesanan(pesananDao.findPesananByNoInvoice(dto.getNoInvoice()).getIdPesanan());
		
		switch (dto.getStatusProduksi()) {
		case "Desain":
			status = 1;
			break;
		case "Konfirmasi":
			status = 2;
			break;
		case "Cetak":
			status = 3;
			break;
		case "Siap":
			status = 4;
			break;
		case "Kirim":
			status = 5;
			break;
		case "Sampai":
			status = 6;
			break;
		default:
			status = 0;
		}
		
		produksi.setStatusProduksi(status);
		produksi.setTanggalMasuk(dto.getTanggalMasuk());
		produksi.setTanggalProduksi(dto.getTanggalProduksi());
		produksi.setTanggalSelesai(dto.getTanggalSelesai());
		
		produksiDao.save(produksi);
		
	}

	@Override
	public void delete(Integer idProduksi) {
		produksiDao.delete(produksiDao.getById(idProduksi));
		
	}
	
}
