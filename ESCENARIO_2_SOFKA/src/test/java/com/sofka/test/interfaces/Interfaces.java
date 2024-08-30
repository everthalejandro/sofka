package com.sofka.test.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Interfaces {

    public static final Target inputSearch = Target.the("input Search")
            .locatedBy("//div//descendant::input[@name='search']");

    public static final Target btn_Search = Target.the("botón buscar")
            .locatedBy("//div[@id='search']/span/button[@type='button']");

    public static final Target btn_AddToCart = Target.the("botón agregar al carrito")
            .locatedBy("//body/div[@id='product-search']//div[3]//div[2]/div[2]/button[1]");

    public static final Target btn_Cart = Target.the("botón ver carrito")
            .locatedBy("//div[@id='cart']");

    public static final Target lnk_Checkout = Target.the("link chekout")
            .locatedBy("div.container div.row div.col-sm-3 div.btn-group.btn-block.open ul.dropdown-menu.pull-right li:nth-child(2) div:nth-child(1) p.text-right a:nth-child(2) > strong:nth-child(1)");

    public static final Target rdb_GuestCheckout = Target.the("opción Guest Checkout")
            .locatedBy("//div//descendant::input[@name='account'][2]");

    public static final Target btn_buttonaccount = Target.the("continuar button-account")
            .locatedBy("//input[@id='button-account']");

    public static final Target input_inputpaymentfirstname = Target.the("input-payment-firstname")
            .locatedBy("//input[@id='input-payment-firstname']");

    public static final Target input_paymentlastname = Target.the("input-payment-lastname")
            .locatedBy("//input[@id='input-payment-lastname']");

    public static final Target input_paymentemail = Target.the("input-payment-email")
            .locatedBy("//input[@id='input-payment-email']");

    public static final Target input_paymenttelephone = Target.the("input-payment-telephone")
            .locatedBy("//input[@id='input-payment-telephone']");

    public static final Target input_paymentpassword = Target.the("input-payment-password")
            .locatedBy("//input[@id='input-payment-password']");

    public static final Target input_paymentconfirm = Target.the("input-payment-confirm")
            .locatedBy("//input[@id='input-payment-confirm']");

    public static final Target input_paymentaddress1 = Target.the("input-payment-address-1")
            .locatedBy("//input[@id='input-payment-address-1']");

    public static final Target input_paymentcity = Target.the("input-payment-city")
            .locatedBy("//input[@id='input-payment-city']");

    public static final Target input_paymentpostcode = Target.the("input-payment-postcode")
            .locatedBy("//input[@id='input-payment-postcode']");

    public static final Target input_paymentcountry = Target.the("input-payment-country")
            .locatedBy("//select[@id='input-payment-country']");

    public static final Target input_paymentzone = Target.the("input-payment-zone")
            .locatedBy("//select[@id='input-payment-zone']");

    public static final Target btn_guest = Target.the("botón guest")
            .locatedBy("//input[@id='button-guest']");

    public static final Target btn_shippingmethod = Target.the("botón shipping-method")
            .locatedBy("//input[@id='button-shipping-method']");

    public static final Target chk_agree = Target.the("aceptar terminos condiciones")
            .locatedBy("//div//descendant::input[@name='agree']");

    public static final Target btn_paymentmethod = Target.the("botón payment-method")
            .locatedBy("//input[@id='button-payment-method']");

    public static final Target btn_confirm = Target.the("botón confirm")
            .locatedBy("//input[@id='button-confirm']");

    public static final Target lbl_Result = Target.the("mensaje de operación")
            .locatedBy("//div[@id='content']/h1");
}