package id.rata.testrata.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesananDto {

	private Integer idPesanan;
	private String noInvoice;
	private String kodeBarang;
	private String namaBarang;
	private Integer jumlahPesanan;
	private BigDecimal totalPesanan;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date tanggalPesanan;
	private String namaPemesan;
	private String alamatPemesan;
	
}
