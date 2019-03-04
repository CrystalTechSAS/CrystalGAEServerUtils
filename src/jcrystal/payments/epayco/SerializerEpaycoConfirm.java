package jcrystal.payments.epayco;

import java.util.function.Consumer;

import jcrystal.payments.epayco.EpaycoConfirm;
import jcrystal.payments.epayco.EpaycoTransactionState;

public class SerializerEpaycoConfirm{
	public static void toJson(java.io.PrintWriter _pw, EpaycoConfirm entidad){
		_pw.print("{");
		jcrystal.PrintWriterUtils.print(_pw, "\"x_amount_ok\":", entidad.x_amount_ok);
		jcrystal.PrintWriterUtils.print(_pw, ",\"x_amount_base\":", entidad.x_amount_base);
		jcrystal.PrintWriterUtils.print(_pw, ",\"x_tax\":", entidad.x_tax);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_cust_id_cliente\":", entidad.x_cust_id_cliente);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_description\":", entidad.x_description);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_id_invoice\":", entidad.x_id_invoice);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_currency_code\":", entidad.x_currency_code);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_franchise\":", entidad.x_franchise);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_transaction_date\":", entidad.x_transaction_date);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_approval_code\":", entidad.x_approval_code);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_transaction_id\":", entidad.x_transaction_id);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_ref_payco\":", entidad.x_ref_payco);
		EpaycoTransactionState val12 = entidad.x_cod_transaction_state;
		if(val12 != null){
			jcrystal.PrintWriterUtils.print(_pw, ",\"x_cod_transaction_state\":", val12.id);
		}
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_transaction_state\":", entidad.x_transaction_state);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_signature\":", entidad.x_signature);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_response\":", entidad.x_response);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_response_reason_text\":", entidad.x_response_reason_text);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_extra1\":", entidad.x_extra1);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_extra2\":", entidad.x_extra2);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_extra3\":", entidad.x_extra3);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_doctype\":", entidad.x_customer_doctype);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_document\":", entidad.x_customer_document);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_name\":", entidad.x_customer_name);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_lastname\":", entidad.x_customer_lastname);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_email\":", entidad.x_customer_email);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_phone\":", entidad.x_customer_phone);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_country\":", entidad.x_customer_country);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_city\":", entidad.x_customer_city);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_address\":", entidad.x_customer_address);
		jcrystal.PrintWriterUtils.printJsonProp(_pw, false, "\"x_customer_ip\":", entidad.x_customer_ip);
		_pw.print("}");
	}
	public static void toJsonEpaycoConfirm(final java.io.PrintWriter _pw, java.lang.Iterable<EpaycoConfirm> lista){
		jcrystal.PrintWriterUtils.toJson(_pw, lista, new Consumer<EpaycoConfirm>() {
			@Override
			public void accept(EpaycoConfirm valor) {
				toJson(_pw, valor);
			}
		});
	}
	public static void toJsonEpaycoConfirm(final java.io.PrintWriter _pw, java.util.Map<Long, EpaycoConfirm> mapa){
		jcrystal.PrintWriterUtils.toJson(_pw, mapa, new Consumer<EpaycoConfirm>() {
			@Override
			public void accept(EpaycoConfirm valor) {
				toJson(_pw, valor);
			}
		});
	}
}
