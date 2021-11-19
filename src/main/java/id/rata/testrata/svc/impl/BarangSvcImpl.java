package id.rata.testrata.svc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.rata.testrata.dao.IBarangDao;
import id.rata.testrata.dto.BarangDto;
import id.rata.testrata.entity.Barang;
import id.rata.testrata.svc.IBarangSvc;

@Transactional
@Service("iBarangSvc")
public class BarangSvcImpl implements IBarangSvc{
	
	@Autowired
	IBarangDao barangDao;

	@Override
	public List<BarangDto> findAllBarang() {
		List<Barang> listBarang = barangDao.findAll();
		List<BarangDto> listDto = new ArrayList<>();
		
		for (Barang brg : listBarang) {
			BarangDto dto = new BarangDto();
			
			dto.setIdBarang(brg.getIdBarang());
			dto.setKodeBarang(brg.getKodeBarang());
			dto.setHargaBarang(brg.getHargaBarang());
			dto.setNamaBarang(brg.getNamaBarang());
			
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public BarangDto findBarangByKodeBarang(String kodeBarang) {
		Barang barang = barangDao.findBarangByKodeBarang(kodeBarang);
		if (barang != null) {
			BarangDto dto = new BarangDto();
			dto.setKodeBarang(barang.getKodeBarang());
			dto.setHargaBarang(barang.getHargaBarang());
			dto.setNamaBarang(barang.getNamaBarang());
			
			return dto;
		}
		return null;
	}

	@Override
	public void save(BarangDto dto) {
		Barang barang = new Barang();
		
		barang.setKodeBarang(dto.getKodeBarang());
		barang.setNamaBarang(dto.getNamaBarang());
		barang.setHargaBarang(dto.getHargaBarang());
		
		barangDao.save(barang);
		
	}

	@Override
	public void update(BarangDto dto) {
		Barang barang = barangDao.getById(dto.getIdBarang());
		
		barang.setKodeBarang(dto.getKodeBarang());
		barang.setNamaBarang(dto.getNamaBarang());
		barang.setHargaBarang(dto.getHargaBarang());
		
		barangDao.save(barang);
	}

	@Override
	public void delete(Integer idBarang) {
		barangDao.delete(barangDao.getById(idBarang));
	}

}
