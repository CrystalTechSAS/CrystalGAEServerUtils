package jcrystal.payments.epayco;

import java.math.BigInteger;
import java.util.Arrays;

public class EpaycoConfirm {
	public String x_cust_id_cliente;
	public String x_description;
	public int x_amount_ok;
	public String x_id_invoice;
	public int x_amount_base;
	public int x_tax;
	public String x_currency_code;
	public String x_franchise	;
	public String x_transaction_date;
	public String x_approval_code;
	public String x_transaction_id;
	public String x_ref_payco;
	public EpaycoTransactionState x_cod_transaction_state;
	public String x_transaction_state;
	public String x_signature	;
	public String x_response	;
	public String x_response_reason_text;
	public String x_extra1;
	public String x_extra2;
	public String x_extra3;
	public String x_customer_doctype;
	public String x_customer_document;
	public String x_customer_name;
	public String x_customer_lastname;
	public String x_customer_email;
	public String x_customer_phone;
	public String x_customer_country;
	public String x_customer_city;
	public String x_customer_address;
	public String x_customer_ip;
	
	private static byte[] hash(String value){
		try{
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
			return md.digest(value.getBytes("UTF-8"));
		}
		catch(java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException ex){
			return null;
		}
	}
	public boolean validateSignature(String x_key){
		byte[] digest = hash(x_cust_id_cliente+"^"+x_key+"^"+x_ref_payco+"^"+x_transaction_id+"^"+x_amount_ok+"^"+x_currency_code);
		String signature = new BigInteger(1, digest).toString(16).toLowerCase();
		System.out.println(Arrays.toString(digest));
		System.out.println(signature);
		System.out.println(x_signature);
		return signature.equals(x_signature.toLowerCase());
	}
/* FROMJSON */
	public EpaycoConfirm(){
	}
	public EpaycoConfirm(org.json.JSONObject json)throws org.json.JSONException{
		this.x_cust_id_cliente = json.has("x_cust_id_cliente")?json.getString("x_cust_id_cliente"):null;
		this.x_description = json.has("x_description")?json.getString("x_description"):null;
		this.x_amount_ok = json.optInt("x_amount_ok");
		this.x_id_invoice = json.has("x_id_invoice")?json.getString("x_id_invoice"):null;
		this.x_amount_base = json.optInt("x_amount_base");
		this.x_tax = json.optInt("x_tax");
		this.x_currency_code = json.has("x_currency_code")?json.getString("x_currency_code"):null;
		this.x_franchise = json.has("x_franchise")?json.getString("x_franchise"):null;
		this.x_transaction_date = json.has("x_transaction_date")?json.getString("x_transaction_date"):null;
		this.x_approval_code = json.has("x_approval_code")?json.getString("x_approval_code"):null;
		this.x_transaction_id = json.has("x_transaction_id")?json.getString("x_transaction_id"):null;
		this.x_ref_payco = json.has("x_ref_payco")?json.getString("x_ref_payco"):null;
		this.x_cod_transaction_state = json.has("x_cod_transaction_state")?EpaycoTransactionState.fromId(json.getInt("x_cod_transaction_state")):null;
		this.x_transaction_state = json.has("x_transaction_state")?json.getString("x_transaction_state"):null;
		this.x_signature = json.has("x_signature")?json.getString("x_signature"):null;
		this.x_response = json.has("x_response")?json.getString("x_response"):null;
		this.x_response_reason_text = json.has("x_response_reason_text")?json.getString("x_response_reason_text"):null;
		this.x_extra1 = json.has("x_extra1")?json.getString("x_extra1"):null;
		this.x_extra2 = json.has("x_extra2")?json.getString("x_extra2"):null;
		this.x_extra3 = json.has("x_extra3")?json.getString("x_extra3"):null;
		this.x_customer_doctype = json.has("x_customer_doctype")?json.getString("x_customer_doctype"):null;
		this.x_customer_document = json.has("x_customer_document")?json.getString("x_customer_document"):null;
		this.x_customer_name = json.has("x_customer_name")?json.getString("x_customer_name"):null;
		this.x_customer_lastname = json.has("x_customer_lastname")?json.getString("x_customer_lastname"):null;
		this.x_customer_email = json.has("x_customer_email")?json.getString("x_customer_email"):null;
		this.x_customer_phone = json.has("x_customer_phone")?json.getString("x_customer_phone"):null;
		this.x_customer_country = json.has("x_customer_country")?json.getString("x_customer_country"):null;
		this.x_customer_city = json.has("x_customer_city")?json.getString("x_customer_city"):null;
		this.x_customer_address = json.has("x_customer_address")?json.getString("x_customer_address"):null;
		this.x_customer_ip = json.has("x_customer_ip")?json.getString("x_customer_ip"):null;
	}
	public EpaycoConfirm(javax.servlet.http.HttpServletRequest req){
		this.x_cust_id_cliente = req.getParameter("x_cust_id_cliente");
		this.x_description = req.getParameter("x_description");
		this.x_amount_ok = req.getParameter("x_amount_ok")!=null?Integer.parseInt(req.getParameter("x_amount_ok")): 0;
		this.x_id_invoice = req.getParameter("x_id_invoice");
		this.x_amount_base = req.getParameter("x_amount_base")!=null?Integer.parseInt(req.getParameter("x_amount_base")): 0;
		this.x_tax = req.getParameter("x_tax")!=null?Integer.parseInt(req.getParameter("x_tax")): 0;
		this.x_currency_code = req.getParameter("x_currency_code");
		this.x_franchise = req.getParameter("x_franchise");
		this.x_transaction_date = req.getParameter("x_transaction_date");
		this.x_approval_code = req.getParameter("x_approval_code");
		this.x_transaction_id = req.getParameter("x_transaction_id");
		this.x_ref_payco = req.getParameter("x_ref_payco");
		this.x_cod_transaction_state = req.getParameter("x_cod_transaction_state")!=null?EpaycoTransactionState.fromId(Integer.parseInt(req.getParameter("x_cod_transaction_state"))):null;
		this.x_transaction_state = req.getParameter("x_transaction_state");
		this.x_signature = req.getParameter("x_signature");
		this.x_response = req.getParameter("x_response");
		this.x_response_reason_text = req.getParameter("x_response_reason_text");
		this.x_extra1 = req.getParameter("x_extra1");
		this.x_extra2 = req.getParameter("x_extra2");
		this.x_extra3 = req.getParameter("x_extra3");
		this.x_customer_doctype = req.getParameter("x_customer_doctype");
		this.x_customer_document = req.getParameter("x_customer_document");
		this.x_customer_name = req.getParameter("x_customer_name");
		this.x_customer_lastname = req.getParameter("x_customer_lastname");
		this.x_customer_email = req.getParameter("x_customer_email");
		this.x_customer_phone = req.getParameter("x_customer_phone");
		this.x_customer_country = req.getParameter("x_customer_country");
		this.x_customer_city = req.getParameter("x_customer_city");
		this.x_customer_address = req.getParameter("x_customer_address");
		this.x_customer_ip = req.getParameter("x_customer_ip");
	}
	public static java.util.ArrayList<EpaycoConfirm> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<EpaycoConfirm> ret = new java.util.ArrayList<EpaycoConfirm>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new EpaycoConfirm(json.getJSONObject(e)));
		}
		return ret;
	}
/* END */
}
