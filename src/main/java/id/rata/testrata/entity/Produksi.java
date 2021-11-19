package id.rata.testrata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_produksi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produksi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produksi")
	private Integer idProduksi;
	
	@Column(name = "id_pesanan")
	private Integer idPesanan;
	
	@Column(name = "status_produksi")
	private Integer statusProduksi;
	
	@Column(name = "catatan_produksi")
	private String catatanProduksi;
	
	@Column(name = "tanggal_masuk")
	private Date tanggalMasuk;
	
	@Column(name = "tanggal_produksi")
	private Date tanggalProduksi;
	
	@Column(name = "tanggal_selesai")
	private Date tanggalSelesai;
}
