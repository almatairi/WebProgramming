# Спецификација за  прва и втора лабораториската вежба

Креирајте нов Spring Boot проект со група mk.finki.ukim.mk и artefactId=lab кој ги има истите зависности како проектот од аудиториските вежби (зависностите може да ги видите во <dependency> тагoвите во pom.xml.
Дефинирајте пакет mk.ukim.finki.wp.lab.model и во него креирајте ја Order класата. Таа треба да содржи:
String balloonColor,
String balloonSize,
String clientName,
String clientAddress и
Long orderId.
Во mk.ukim.finki.wp.lab.model креирајте Balloon класа која ќе содржи:
String name,
String description
Креирајте класа BalloonRepository во пакетот mk.ukim.finki.wp.lab.repository, во која ќе чувате List<Balloon> иницијализирана со 10 вредности.
Имплементирајте метод public List<Balloon> findAllBalloons(); кој само ќе ја врати листата.
Имплементирајте метод public List<Balloon> findAllByNameOrDescription(String text); кој ќе направи пребарување низ листата на балони и ќе ги врати оние во чие име или опис се содржи текстот text кој се праќа како аргумент на методот.
Дефинирајте ги следните интерфејси во mk.ukim.finki.wp.lab.service кои ќе ги претставуваат бизнис функционалностите на апликацијата:

public interface BalloonService {
     List<Balloon> listAll();
     List<Balloon> searchByNameOrDescription(String text);
}
public interface OrderService{
    Order placeOrder(String balloonColor, String clientName, String address);
}
Имплементирајте ги сервисите (BalloonService треба да зависи од BalloonRepository).
Креирајте сервлет BalloonListSevlet во пакетот mk.ukim.finki.lab.web и мапирајте го на патеката /. Овој сервлет треба да зависи од BalloonService и да ги прикаже сите добиени балони од методот listAll().

Прилагодете го фајлот listBalloons.html за изгледот на оваа страница.
<html>
<head>
    <meta charset="utf-8">
    <title>Balloon Order page - Welcome and choose a Balloon</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome to our Balloon Shop App</h1>
</header>
<main>
    <h2>Choose balloon color:</h2>
    <input type="radio" name="color" value="Red Balloon"> Red Balloon<br/>
    <input type="radio" name="color" value="Green Balloon"> Green Balloon<br/>
    <input type="radio" name="color" value="Yellow Balloon"> Yellow Balloon<br/>
    <input type="radio" name="color" value="Blue Balloon"> Blue Balloon<br/>

    <br/>
    <a href="/selectBalloonSize.html">Submit</a>
</main>
</body>
</html>
При избор на балон, треба да го запаметите изборот. За оваа цел креирајте сервлет SelectBalloonServlet мапиран на /selectBalloon.

Овој сервлет треба да ја прикажете страната за избор на големина на балон
Во фолдерот src/main/resources/templates додадете фајл selectBalloonSize.html.
Во страницата треба да има форма од која ќе се избере големината на балонот.
Типот на елементите во формата е radio.
При клик на Submit копчето од оваа форма треба да се повика сервлетот на адресата /BalloonOrder.
Прилагодете го фајлот selectBalloonSize.html за изгледот на оваа страница.
<html>
<head>
    <meta charset="utf-8">
    <title>Balloon Order page - Balloon Size</title>
    <style type = "text/css">
        body {
            width: 800px;
            margin: auto;
        }
        table {
            width:100%;
        }
        table, td, th {
            border: 1px solid black;
            padding:3px 2px;
        }
        section {
            float: left;
            margin: 0 1.5%;
            width: 63%;
        }
        aside {
            float: right;
            margin: 0 1.5%;
            width: 30%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Balloon Order page - Select Balloon Size </h1>
    </header>
    <section>
        <h2>Choose balloon size:</h2>
        <input type="radio" name="size" value="Small"> Small <br/>
        <input type="radio" name="size" value="Medium"> Medium <br/>
        <input type="radio" name="size" value="Big"> Big <br/>
        <input type="radio" name="size" value="Extra Big"> Extra Big <br/>
        <br/>
        <a href="/deliveryInfo.html">Submit</a>
    </section>
    <aside>
        <table>
            <tr>
                <th colspan="2">
                    Your Order Status
                </th>
            </tr>
            <tr>
                <td><b>Balloon Type </b></td>
                <td>Red Balloon</td>
            </tr>
        </table>
    </aside>

</body>
</html>
Креирајте сервлет со име BalloonOrderServlet во пакетот mk.ukim.finki.wp.lab.web и мапирајте го на /BalloonOrder.do патеката.
Овој сервлет треба да ја постави вредноста за големината на нарачаниот балон во сесија и да го прикаже темплејтот deliveryInfo.html.

За да поставите информации во сесија, искористете: request.getSession().setAttribute(“yourAttributeName”, attributeValue)
Прилагодете го фајлот deliveryInfo.html за изгледот на оваа страница.
<html>
       <head>
           <meta charset="utf-8">
           <title>WP lab - Delivery Info</title>
           <style type="text/css">
               body {
                   width: 800px;
                   margin: auto;
               }
               table {
                   width: 100%;
               }

               table, td, th {
                   border: 1px solid black;
                   padding: 3px 2px;
               }

               section {
                   float: left;
                   margin: 0 1.5%;
                   width: 63%;
               }

               aside {
                   float: right;
                   margin: 0 1.5%;
                   width: 30%;
               }
           </style>
       </head>
       <body>
           <header>
               <h1>Balloon Order page - Delivery information </h1>
           </header>
           <section>

               <form method="" action="">
                   <label for="clientName">Client Name:</label><br/>
                   <input type="text" id="clientName" name="clientName"/><br/>
                   <label for="clientAddress">Delivery Address:</label><br/>
                   <textarea cols="40" rows="3" id="clientAddress" name="clientAddress"></textarea><br/>
                   <a href="/confirmationInfo.html">Submit</a>
               </form>

           </section>
           <aside>
               <table>
                   <tr>
                       <th colspan="2">
                           Your Order Status
                       </th>
                   </tr>

                   <tr>
                       <td><b>Balloon Color </b></td>
                       <td>Red Balloon</td>
                   </tr>
                   <tr>
                       <td><b>Balloon Size </b></td>
                       <td>Large</td>
                   </tr>
               </table>
           </aside>
       </body>
   </html>
Страната генерирана од овој сервлет има Submit копче кое не’ носи на сервлетот со локација /ConfirmationInfo.

Да се креира сервлет со име ConfirmationInfoServlet, мапиран на патеката /ConfirmationInfo.

Овој сервлет треба да го испечати пребарувачот и оперативниот систем на корисникот, неговото име, адреса, бојата и големината на балонот кој го избрал корисникот.
Копчето Log out треба да ја поништи тековната сесија на корисникот и да го редиректира на првата страница /.
Прилагодете го фајлот confirmationInfo.html за изгледот на оваа страница.
<html>
<head>
    <meta charset="utf-8">
    <title>WP lab - Confirmation Info</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
        }
        table {
            width:100%;
        }
        table, td, th {
            border: 1px solid black;
            padding: 3px 2px;
        }
    </style>
</head>
<body>
<section>
    <header>
        <h1>Balloon Order page - Order confirmation </h1>
    </header>
    <table>
        <tr>
            <th colspan="2">
                Your Order Status
            </th>
        </tr>
        <tr>
            <td><b>Client Name </b></td>
            <td>Petko Petkov</td>
        </tr>
        <tr>
            <td><b>Client Address </b></td>
            <td>Partizanska 5, Skopje</td>
        </tr>
        <tr>
            <td><b>Client IP Address</b></td>
            <td>127.0.0.1</td>
        </tr>
        <tr>
            <td><b>Client Browser</b></td>
            <td>Mozilla</td>
        </tr>
        <tr>
            <td><b>Balloon Color </b></td>
            <td>Red Balloon</td>
        </tr>
        <tr>
            <td><b>Balloon Size </b></td>
            <td>Large</td>
        </tr>
    </table>
    <div>
        <a href="/">Log out</a>
    </div>


</section>
</body>
</html>
Освен за чекорот за селекција на боја на балон, за сите останати сервлети овозможете проверка за тоа дали е избрана бојата на балонот во првиот чекор. Во случаите кога нема селектирано боја на балон, потребно е да направите редирекција на страната за приказ на овозможени бои на балонот. Што ќе искористите за имплементација на оваа функционалност?
  
  Во оваа вежба ќе треба да продолжите со работа во рамки на проектот од претходната лабораториска вежба.
Во класата Balloon додадете уште едно својство, private Long id, кое е уникатно за секој балон. Притоа, id генерирајте за секој балон, како што е направено во рамки на аудиториската вежба.
Додадете класа Manufacturer во рамки на пакетот mk.ukim.finki.wp.lab.model. Во истата ќе чувате:
private Long id
private String name
private String country
private String address
Во класата Balloon додадете го производителот како посебно својство.
Креирајте ManufacturerRepository класа во пакетот mk.ukim.finki.wp.lab.repository, и во неа иницијализирајте листа во која ќе има 5 производители. Во рамки на класата напишете и метод public List<Manufacturer> findAll() кој ги враќа сите производители.
Во рамки на пакетот mk.ukim.finki.wp.lab.service креирајте интерфејс ManufacturerService како и класа која го имплементира ManufacturerServiceImpl (во impl подпакетот). Нека во овој сервис се креира метод public List<Manufacturer> findAll() кој го повикува соодветниот метод од ManufacturerRepository.
Дефинирајте пакет mk.ukim.finki.wp.lab.web.controller и во него креирајте ја BalloonController класата.
Имплементирајте метод public String getBalloonsPage(@RequestParam(required = false) String error, Model model) кој само треба да го прикаже погледот на сите балони. Нека одговара на mapping /balloons. Погледот на сите балони нека биде listBalloons.html, со тоа што во него ќе ги направите потребните промени, притоа оставајќи ја функционалноста на избирање на балон и навигирање кон следната страна за големини. Дополнително, направете и промена во филтерот, со цел да сега повторно ова е почетната страна во рамки на апликацијата.
Имплементирајте метод public String saveBalloon() кој како request параметри ќе ги прими името, описот за балонот, како и id на производителот. Нека одговара на mapping /balloons/add, и при успешно додаден или едитиран балон нека редиректира кон погледот со сите балони.
Имплементирајте метод public String deleteBalloon(@PathVariable Long id). Нека одговара на mapping /balloons/delete/{id}, и при успешно избришан балон од листата повторно нека ја прикажува листата со балони.
Внимавајте како ќе бидат анотирани методите од барањето 7, зависно нивната функционалнст.
Имајќи ги предвид методите на web слојот кои треба да ги имплементирате, креирајте ги сите потребни методи во рамки на сервисниот слој.
Имајќи ги предвид методите на service слојот кои треба да ги имплементирате, креирајте ги сите потребни методи во рамки на repository слојот.
Креирајте страна add-balloon.html, која треба да прикажува форма за додавање на нов балон. Истата форма би требало да се употреби и за едитирање на балон, при што за еден балон може да ги менуваме само името, описот и производителот (за ова може да искористите готов html template или пак оној од проектот од аудиториски вежби, при што соодветно ќе го прилагодите). Дополнително, имајте предвид дека за производителот би имале <select> таг, односно ќе може да избираме од сите производители.
Во рамки на listBalloons.html, додадете копчe за бришење на балон и копче за едитирање на балон (во рамки на секој item во листата). Дополнително, додадете копче за додавање на нов балон кон листата (слично како што се прави во рамки на аудиториската вежба).
До овој момент треба да имате целосна функционалност на прикажување на сите балони во листата, како и бришење на еден балон од истата. Повторно, потребно е да ја надополните BalloonController класата.
Имплементирајте метод public String getEditBalloonPage(), кој одговара на mapping /balloons/edit-form/{id}. Направете ги сите потребни промени во дефиницијата на методот за да го овозможите ова. Овој метод треба да ја прикаже add-balloon.html страната. Кога едитираме балон, потребно е во рамки на формата да се прикажуваат неговите моментални податоци (слично како во проектот од аудиториската вежба). Дополнително, доколку се пристапи патеката /balloons/edit-form/{id}, со id за кое нема балон во рамки на листата, нека се направи редирект кон листата со балони, при што ќе се прикаже и порака за грешка.
Имплементирајте метод public String getAddBalloonPage(), кој одговара на mapping /balloons/add-form и ја прикажува add-balloon.html страната.
Формата која се наоѓа на add-balloon.html страната, ќе прави POST барање кон BalloonController, со што ќе овозможите креирање на нов балон или пак едитирање на балон.
Доколку при имплементацијата на вежбата има потреба од дополнителни методи во рамки на сервисниот или repository слојот, додадете ги (пр. метод за пребарување на балон или производител според id).
Дополнително креирајте страна userOrders.html, на која ќе ги прикажете сите нарачки за тековниот корисник (оној кој го имате во сесија). Барањето за сите нарачки нека биде на mapping /orders. До оваа страна нека се пристапува преку копче кое ќе го поставите во рамки на confirmationInfo.html. Остатокот од имплементацијата на оваа функционалност е аналоген со претходно.
