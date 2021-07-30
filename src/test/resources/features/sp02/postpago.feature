@sp01
Feature: Compra de un celular con en plan PostPago
Como usuario quiero comprar un nuevo equipo en un plan PostPago

Scenario: Un usuario realiza la compra de un celular en plan postpago con una linea nueva para Lima 

Given estoy en la pagina principal de tienda claro LN
When selecciono el menu celulares, luego el submenu postpago y luego seleccion la opcion linea nueva LN
And selecciono un producto del catalogo LN
And selecciono Aniadir a mi bolsa LN
And observo el resumen de mi compra y selecciono Siguiente LN
And completo el formulario con mis datos personales y seleccion Siguiente LN
And acepto los terminos y condiciones de pago y las condiciones y selecciono Siguiente LN
Then visualizo el checkout LN

Scenario: Un usuario realiza la compra de un celular en plan postpago Portabilidad para Lima 

Given estoy en la pagina principal de tienda claro PRT
When selecciono el menu celulares, luego el submenu postpago y luego seleccion la opcion Portabilidad PRT
And selecciono un producto del catalogo PRT
And selecciono Aniadir a mi bolsa PRT
And observo el resumen de mi compra y selecciono Siguiente PRT
And completo el formulario con mis datos personales y seleccion Siguiente PRT
And acepto los terminos y condiciones de pago y las condiciones y selecciono Siguiente PRT
Then visualizo el checkout PRT

Scenario: Un usuario realiza la compra de un celular en plan postpago Renovacion para Lima 

Given estoy en la pagina principal de tienda claro RN
When selecciono el menu celulares, luego el submenu postpago y luego seleccion la opcion Renovacion RN
And selecciono un producto del catalogo RN
And selecciono Aniadir a mi bolsa RN
And observo el resumen de mi compra y selecciono Siguiente RN
And completo el formulario con mis datos personales y seleccion Siguiente RN
And acepto los terminos y condiciones de pago y las condiciones y selecciono Siguiente RN
Then visualizo el checkout RN
