![image alt text](image_0.png)

**Pomelo**

Welcome to **Payment Processor**

En la siguiente docu te vas a encontrar con varios recursos de utilidad para comenzar tu camino en Pomelo y en el equipo 🤗. 

[[TOC]]

# Comencemos

## Arquitectura

Para comenzar vamos a revisar un poco la arquitectura de alto nivel sobre que hace el equipo y con quienes interactuamos.

Usamos [Whimsical](https://whimsical.com) para hacer nuestros diagramas. Si es que ya no te dieron acceso, pedile a cualquiera del equipo 😉.

El diagrama lo [encontrás acá](https://whimsical.com/architecture-UjWDWn9WW2F1WECoxhrr1t), si no te agendaron una juntada te invitamos a hacerlo 🙂, así revisamos juntos y en detalle de que se trata.

## Especificaciones

WTF? ISO, bits...🥴, tranca, en [este docu](https://docs.google.com/presentation/d/1EPZfsDwQwgUR5uMR-UY3lbQnyit9K-8JM4H4nKYKvhA/edit#slide=id.gce3f09c8b2_0_0) el equipo armó un resumen que siempre es de consulta (para todos).

También van a servirte los [manuales de mastercard](https://drive.google.com/drive/u/2/folders/16iqL7N8VKsGQKz8qzvtwtBDNFo_QL01Z), y [los de producto](https://drive.google.com/drive/u/2/folders/1waEjei15Sm5IF-wEysqsAuGZUQ4RqJTD) para el procesador.

Por último un "ayuda memoria" 😁de los códigos (es cuando escuches hablar los 100, los 400, etc 😉)

[MTI Processing Code](https://docs.google.com/spreadsheets/d/1iGZv8tTioApZlC0-zApneRFnjtwAxjb3-wQ9LovHCjY/edit#gid=0) 

# Herramientas para desarrollo

## Lenguajes

Usamos java como lenguaje principal y jPOS para convertir los mensajes en formato ISO 8583 a XML (o CMF). Para más info de jPOS te dejamos [esta guía](http://jpos.org/doc/proguide-draft.pdf).

Mencionamos java pero no que versiones, usamos el jdk 8 de Oracle y jdk 11 (cualquier vendor).

## SDKman

Usamos también [sdkman](https://sdkman.io/install) para switchear las versiones de java y gradle (gradle 6.8.3 para jcard y 7 para el resto).

TIPs

Una vez instalado sdkman verifica que versiones hay disponibles de java:

* sdk list java

Como te contamos anteriormente usamos jdk 8 y jdk 11 los instalas de la siguiente manera

* sdk install java 11.0.2-open

* sdk install java 8.0.302-zulu

Para switchear entre versiones

* sdk use java 11.0.2-open

Para gradle

* sdk list gradle

Y a instalar las versiones que te comentamos

* sdk install gradle 6.8

* sdk install gradle 7.0

Igual que con java para switchear:

* sdk use gradle 7.0

## Containerized

Usamos [docker](https://docs.docker.com/engine/install/) como tecnología de contenedores

## Microsoft Remote Desktop

Recordás la cajita que dice **MIP** en el diagrama de whimsical? bueno usamos [Microsoft Remote Desktop](https://apps.apple.com/ar/app/microsoft-remote-desktop/id1295203466?l=en&mt=12) para simular una operación, tenemos tres simuladores te dejamos la configuración de cada uno.

### SIMU 1

- H: ec2-3-235-67-240.compute-1.amazonaws.com

- U: Administrator

- P: z-C-5Y(SwPy)EdAOjT$T=dBuC3HCiDgc

No tiene andando el simulador de clearing

### SIMU 2

- H: ec2-54-242-154-248.compute-1.amazonaws.com

- U: Administrator

- P: z-C-5Y(SwPy)EdAOjT$T=dBuC3HCiDgc

### SIMU 3

- H: ec2-54-147-28-10.compute-1.amazonaws.com

- U: Administrator

- P: z-C-5Y(SwPy)EdAOjT$T=dBuC3HCiDgc

SIMU DEV

- H: ec2-54-158-44-76.compute-1.amazonaws.com

- U: Administrator

- P: z-C-5Y(SwPy)EdAOjT$T=dBuC3HCiDgc

Nuevamente te pedimos que proactivamente consultes a cualquiera del equipo para conocer más detalles de como usarlo.

Todo bien hasta acá, pero los repositorios?

## Repositorios

Usamos github para el remoto en Pomelo, si no tenés cuenta podés [crearla acá](https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home), si ya tenes una pedile al equipo que te agreguen a la organización.

No te olvides de cargar la public ssh_key a tu cuenta. Si te olvidaste como hacerlo no hay drama, [acá vas a encontrar toda la info](https://docs.github.com/es/github/authenticating-to-github/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent) 😉

Y acá te dejamos todos los repos:

Los principales

* [network-connector](https://github.com/pomelo-la/network-connector/)

* [mastercard-connector](https://github.com/pomelo-la/mastercard-connector)

* [transaction-orchestrator](https://github.com/pomelo-la/transaction-orchestrator)

* [mastercard-clearing-connector](https://github.com/pomelo-la/mastercard-clearing-connector)

* [jcard](https://github.com/pomelo-la/jcard-db)[-db](https://github.com/pomelo-la/jcard-db) (donde guardamos las migraciones)

El de archiving (esta por si hay que ir a mirar algo viejo nomas)

* [pomelo-JCard-md](https://github.com/pomelo-la/pomelo-jCard-md/)

# Configuraciones y start up de cada repo

* [transaction-orchestrator](https://github.com/pomelo-la/transaction-orchestrator) **java 11.x y gradle 7.x **[README](https://github.com/pomelo-la/transaction-orchestrator/blob/master/README.md)

* [network-connector](https://github.com/pomelo-la/network-connector/) **java 8.x y gradle 6.8 **[README](https://github.com/pomelo-la/network-connector/blob/master/README.md)

* [mastercard-connector](https://github.com/pomelo-la/mastercard-connector) **java 8.x y gradle 6.8 **[README](https://github.com/pomelo-la/mastercard-connector/blob/master/README.md)

* [mastercard-clearing-connector](https://github.com/pomelo-la/mastercard-clearing-connector)** java 8.x y gradle 6.8 **[README](https://github.com/pomelo-la/mastercard-clearing-connector/blob/master/README.md)

Nota: en caso de un error de tipo maven no se encuentra o un error de importación en el proyecto como Gradle, correr en la raíz del repo el comando **gradle wrapper**

# Conceptos del dominio - Glosario

### **MIP **

MIP. *MasterCard Interface Processor—The processor (place on-site at a merchant's facility) that interfaces with MasterCard's Global Payment System communications network. *

En otras palabras, el servicio de MasterCard, para nosotros los SIMU’s.

### **DE**

 Data element es como un campo que viene en el request del MIP

**DE04** = data elemento 4

..

**DE48** = data elemento 48

Cada DE tiene sub elementos, los cuales JCard concatena con "." (punto)

    "sub elementos"

    sub elemento 7 -->** DE48.7**

### **MTI / itc** 

Es el tipo de transacción (lo vas a ver mapeado en el participante "switch" en jCard)  (autorización, aviso, reversa, login/network)

function code / pcode / processing code = subtipo de transaccion (purchase, withdrawal, refund, payment, balance inquiry, etc)

**MTIs:**

*     100 -> autorizaciones (apruebo o rechazo?)

*     120 -> advices (no se aprueban ni rechazan, mastercard nos avisa de algo)

*     2xx -> presentaciones (clearing)

*     400 -> reversas (revierte una autorización pasada)

*     420 -> advices de reversas

*     8xx -> mensajes de networking entre MIP/simu y MC (echos, login, pings, etc)

**FC - function codes:**

*     00 -> compra (en pos, ecommerce, etc)

*     01 -> atm withdrawal

*     09 -> compra + retiro de efectivo (aka: cashback / extracash)

*     17 -> cash disbursement (quizas no aplique)

*     20 -> refund (reintegrale/acreditarle cierta plata al cardholder)

*     28 -> payment (acreditarle plata al cardholder. Ej1: pagos p2p -> tarjeta A envia dinero a tarjeta B. Ej2: 5% de dto en restaurantes con mastercard)

*     30 -> balance inquiry (consulta de saldo via atm)

*     92 -> pin change (nosotros no lo soportamos)

**_*Para más información sobre los codecs y su significado, consultar el_****_[ manual de mastercar_**d](https://drive.google.com/file/d/1mDcZi_MeKOmw21BjgYRtCvz3feRSL3JE/view?usp=sharing)

**Combinaciones MTI + FC:**

    ej: **100.09** --> autorización de un extracash (tiene plata para autorizar la compra?)

    ej: **400.09** --> reversa de un extracash (como le cobre antes, ahora le tengo que devolver)

    ej: **220.09** --> presentación de un extracash en clearing (ponele, no recuerdo el codigo exacto)

    ej:** 100.20** --> autorización de refund (recomiendan siempre autorizar para evitar mal ux)

                     tema fraude: que pasa si alguien se auto manda refunds?

                        -> guardarlas en HELD: se aprueba la txn a mastercard, pero no se impactan

                                               los fondos en el balance del usuario en el momento.

                                               Cuando llegue la presentación se le reintegra al usuario.

### **Casos de Uso**

1) user genera un refund fraudulento

2) pomelo lo aprueba (siempre se aprueba)

NO  ~3) pomelo le impacta la plata al usuario~

NO  ~4) el usuario lo ve en su wallet~

5) el usuario se compra algo por $1M --> rechazado por saldo insuficiente

6) alguien se da cuenta del fraude en 1) y no se lo presenta a pomelo

    --> la txn queda HELD forever y nunca se mueven fondos

**o**

6) nadie se da cuenta del fraude y le presentan 1) a pomelo (llega en el clearing)

    --> genero un refund y le acredito la plata al usuario

### **Autorizaciones más populares:**

*    ** 100.00, 100.01, 100.09****, ****100.20, 100.28**

* **   **** 100.00, 100.01, 100.09** : sacan plata

*    ** ****100.20, 100.28** : ponen plata

### **Reversas**

Las reversas ponen o sacan plata al usuario? depende

    reversa de una compra --> devuelve plata* (te había sacado plata antes)

    reversa de un  refund --> sacar plata   * (te había devuelto plata antes)

    * Estas operaciones se conocen como "**_forzadas_**". El cliente tiene poner/sacar

      la plata de la cuenta del cardholder obligatoriamente, no puede aprobar/rechazar.

      ej1: reversa de una compra: hay que acreditar forzosamente el dinero

      ej2: diferencias en IPM (para arriba o para abajo)

      ej3: se presenta en IPM una txn que estaba en estado HELD, entonces hay

            que forzarla para acreditarle al usuario en ese momento

### **Advices**

Mastercard nos avisa de algo que hizo por nosotros

    ej: aprobar algo. Con prepago no sucede nunca. Con crédito, si nosotros estamos

        caídos y mastercard considera que la txn es de bajo riesgo (considerando

        credito disponible y monto de la txn), ellos podrian aprobar por nosotros.

        En cuanto pomelo esta back online, mastercard nos avisa de que la txn

        se aprobo.

        Como con prepago no sucede nunca, no vamos a recibir nunca este tipo de

        txns, ergo no lo implementamos.

    ej: rechazar algo. Tipo pomelo estaba caído, master rechazo y nos avisa

        "de onda", no es que pomelo tenga que reaccionar a eso.

        Así y todo producto quiere que las guardemos

# Metodología

Estamos haciendo sprints de una semana de (miércoles a miércoles) y hacemos daily todos los días a las 10am hora argentina, si no te sumaron pedí que te agreguen a las meet 😉.

Y de paso te dejamos acceso [al tablero](https://app.clickup.com/3121743/v/b/li/17854095?pr=3241155)

Creemos que por ahora es la mínima información que podemos darte para que puedas arrancar.

Éxitos 🎊 🎉 🎊 🎉

