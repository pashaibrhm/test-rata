package id.rata.testrata.svc.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.rata.testrata.dao.IBarangDao;
import id.rata.testrata.dao.IPesananDao;
import id.rata.testrata.dto.PesananDto;
import id.rata.testrata.entity.Barang;
import id.rata.testrata.entity.Pesanan;
import id.rata.testrata.svc.IPesananSvc;

@Transactional
@Service("iPesananSvc")
public class PesananSvcImpl implements IPesananSvc{
	
	@Autowired
	IPesananDao pesananDao;
	
	@Autowired
	IBarangDao barangDao;

	@Override
	public List<PesananDto> findAllPesanan() {
		List<PesananDto> listDto = new ArrayList<>();
		List<Object[]> listPesanan = pesananDao.findAllPesanan();
		
		for (Object[] obj : listPesanan) {
			PesananDto dto = new PesananDto();
			
			dto.setIdPesanan((Integer) obj[0]);
			dto.setNoInvoice((String) obj[1]);
			dto.setKodeBarang((String) obj[2]);
			dto.setNamaBarang((String) obj[3]);
			dto.setJumlahPesanan((Integer) obj[4]);
			dto.setTotalPesanan((BigDecimal) obj[5]);
			dto.setTanggalPesanan((Date) obj[6]);
			dto.setNamaPemesan((String) obj[7]);
			dto.setAlamatPemesan((String) obj[8]);
			
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public PesananDto findPesananByNoInvoice(String noInvoice) {
		Pesanan pesanan = pesananDao.findPesananByNoInvoice(noInvoice);
		
		if (pesanan != null) {
			PesananDto dto = new PesananDto();
			Barang barang = barangDao.findBarangByKodeBarang(pesanan.getKodeBarang());
			BigDecimal jumlahPesanan = BigDecimal.valueOf(pesanan.getJumlahPesanan());
			BigDecimal hargaBarang = barang.getHargaBarang();
			
			
			dto.setNoInvoice(pesanan.getNoInvoice());
			dto.setKodeBarang(pesanan.getKodeBarang());
			dto.setAlamatPemesan(pesanan.getAlamatPemesan());
			dto.setNamaBarang(barang.getNamaBarang());
			dto.setJumlahPesanan(pesanan.getJumlahPesanan());
			dto.setNamaPemesan(pesanan.getNamaPemesan());
			dto.setTanggalPesanan(pesanan.getTanggalPesanan());
			dto.setTotalPesanan(hargaBarang.multiply(jumlahPesanan));

			return dto;
		}
		
		return null;
	}

	@Override
	public void save(PesananDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PesananDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer idPesanan) {
		// TODO Auto-generated method stub
		
	}

}
