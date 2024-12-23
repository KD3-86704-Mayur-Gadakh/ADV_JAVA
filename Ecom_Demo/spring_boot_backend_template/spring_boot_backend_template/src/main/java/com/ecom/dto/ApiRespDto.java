package com.ecom.dto;



	
	
	

	import java.time.LocalDateTime;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@NoArgsConstructor
	@Getter
	@Setter
	public class ApiRespDto {
		private String message;
		private LocalDateTime timeStamp;

		public ApiRespDto(String message) {
			super();
			this.message = message;
			this.timeStamp = LocalDateTime.now();
		}

	}


