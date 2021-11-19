package id.rata.testrata.svc.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.rata.testrata.config.CommonLibrary;
import id.rata.testrata.dao.IPembayaranDao;
import id.rata.testrata.dao.IPesananDao;
import id.rata.testrata.dao.IProduksiDao;
import id.rata.testrata.dto.PembayaranDto;
import id.rata.testrata.entity.Pembayaran;
import id.rata.testrata.entity.Produksi;
import id.rata.testrata.svc.IPembayaranSvc;

@Transactional
@Service("iPembayaranSvc")
public class PembayaranSvcImpl implements IPembayaranSvc {

	@Autowired
	IPembayaranDao pymtDao;
	
	@Autowired
	IPesananDao pesananDao;
	
	@Autowired
	IProduksiDao produksiDao;
	
	CommonLibrary commonLibrary;

	@Override
	public List<PembayaranDto> findAllPembayaran() {
		List<PembayaranDto> listDto = new ArrayList<>();
		List<Object[]> listPembayaran = pymtDao.findAllPembayaran();

		for (Object[] obj : listPembayaran) {
			PembayaranDto dto = new PembayaranDto();

			dto.setNoInvoice((String) obj[0]);
			dto.setMetodePembayaran((String) obj[1]);
			dto.setBuktiPembayaran((String) obj[2]);
			dto.setStatusPembayaran((String) obj[3]);
			dto.setTanggalPembayaran((Date) obj[4]);

			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public void save(PembayaranDto dto) {
		Pembayaran pembayaran = new Pembayaran();
		Integer metode = 0;
		Integer status = 0;

		pembayaran.setIdPesanan(dto.getIdPesanan());
		switch (dto.getMetodePembayaran()) {
		case "Transfer":
			metode = 1;
			break;
		case "CC":
			metode = 2;
			break;
		case "Shopee":
			metode = 3;
			break;
		case "Tokopedia":
			metode = 4;
			break;
		default:
			metode = 0;
		}
		
		switch (dto.getStatusPembayaran()) {
		case "Pending":
			status = 1;
			break;
		case "Lunas":
			status = 2;
			break;
		case "Batal":
			status = 3;
			break;
		default:
			status = 0;
		}
		
		pembayaran.setMetodePembayaran(metode);
		pembayaran.setBuktiPembayaran("-");
		pembayaran.setStatusPembayaran(status);
		pembayaran.setTanggalPembayaran(dto.getTanggalPembayaran());
		
		pymtDao.save(pembayaran);	
	}

	@Override
	public void update(PembayaranDto dto) {
		Pembayaran pembayaran = pymtDao.getById(dto.getIdPembayaran());

		Integer metode = 0;
		Integer status = 0;

		pembayaran.setIdPesanan(dto.getIdPesanan());
		switch (dto.getMetodePembayaran()) {
		case "Transfer":
			metode = 1;
			break;
		case "CC":
			metode = 2;
			break;
		case "Shopee":
			metode = 3;
			break;
		case "Tokopedia":
			metode = 4;
			break;
		default:
			metode = 0;
		}
		
		switch (dto.getStatusPembayaran()) {
		case "Pending":
			status = 1;
			break;
		case "Lunas":
			status = 2;
			break;
		case "Batal":
			status = 3;
			break;
		default:
			status = 0;
		}
		
		pembayaran.setMetodePembayaran(metode);
		pembayaran.setBuktiPembayaran("-");
		pembayaran.setStatusPembayaran(status);
		pembayaran.setTanggalPembayaran(dto.getTanggalPembayaran());
		
		pymtDao.save(pembayaran);
		
		if (status == 2) {
			insertDataProduksi(produksiDao.getProduksiByIdPesanan(dto.getIdPesanan()));
		}
	}

	@Override
	public void delete(Integer idPembayaran) {
		Pembayaran pembayaran = pymtDao.getById(idPembayaran);
		pymtDao.delete(pembayaran);
	}
	
	public void insertDataProduksi(Produksi prdk) {
		
		prdk.setTanggalMasuk(commonLibrary.getDateTimeNow());
		prdk.setTanggalProduksi(commonLibrary.getDateTimeNow());
		prdk.setTanggalSelesai(commonLibrary.getDateTimeNow());
		
		produksiDao.save(prdk);
	}

}
