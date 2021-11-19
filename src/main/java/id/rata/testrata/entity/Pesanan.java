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
@Table(name = "tbl_pesanan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pesanan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pesanan")
	private Integer idPesanan;
	
	@Column(name = "no_invoice")
	private String noInvoice;
	
	@Column(name = "jumlah_pesanan")
	private Integer jumlahPesanan;
	
	@Column(name = "tanggal_pesanan")
	private Date tanggalPesanan;
	
	@Column(name = "kode_barang")
	private String kodeBarang;
	
	@Column(name = "nama_pemesan")
	private String namaPemesan;
	
	@Column(name = "alamat_pemesan")
	private String alamatPemesan;

}
