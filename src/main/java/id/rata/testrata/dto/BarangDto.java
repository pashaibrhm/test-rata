package id.rata.testrata.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarangDto {

	private Integer idBarang;
	private String kodeBarang;
	private String namaBarang;
	private BigDecimal hargaBarang;
}
