/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.payments.epayco;

public enum EpaycoTransactionState {
	Aceptada(1),Rechazada(2),Pendiente(3),Fallida(4),Reversada(6),Retenida(7),Iniciada(8),Expirada(9),Abandonada(10),Cancelada(11),Antifraude(12);
	public final int code;
	public final int id;
	private EpaycoTransactionState(int code) {
		this.code = code;
		this.id = code;
	}
	public static EpaycoTransactionState fromId(int code) {
		for(EpaycoTransactionState state : values())if(code == state.code)return state;
		return null;
	}
}
