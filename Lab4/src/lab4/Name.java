/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Random;

/**
 *
 * @author Алексей
 */
public enum Name {
    АБРАМ,
    АВГУСТ, АВДЕЙ, АВЕРКИЙ, АВКСЕНТИЙ, АВРААМ, АВТОНОМ, АГАП, АГАФОН, АГГЕЙ, АГЕЙ, АДАМ, АДРИАН, АЗАРИЙ, АКИМ, АЛЕКСАНДР, АЛЕКСЕЙ, АМВРОСИЙ, АМОС,
    АНАНИЙ, АНАТОЛИЙ, АНДРЕЙ, АНДРИАН, АНДРОН, АНДРОНИК, АНИКЕЙ, АНИКИТА, АНИСИМ, ОНИСИМ, АНТИП, АНТОН, АНТОНИН, АПОЛЛИНАРИЙ, АПОЛЛОН, АРЕФИЙ,
    АРИСТАРХ, АРКАДИЙ, АРСЕНИЙ, АРТЕМ, АРТЁМ, АРТЕМИЙ, АРХИП, АСКОЛЬД, АФАНАСИЙ, АФИНОГЕН,
    БАЖЕН, БОГДАН, БОЛЕСЛАВ, БОРИС, БОРИСЛАВ, БОЯН, БРОНИСЛАВ, БУДИМИР, ВАДИМ, ВАЛЕНТИН, ВАЛЕРИЙ, ВАЛЕРЬЯН, ВАРЛААМ, ВАРЛАМ, ВАРФОЛОМЕЙ, ВАСИЛИЙ, ВАСИЛИСК, ВЕЛИМИР, ВЕНЕДИКТ, ВЕНИАМИН, ВИКЕНТИЙ, ВИКТОР, ВИКТОРИН, ВИССАРИОН, ВИТАЛИЙ, ВЛАДИЛЕН, ВЛАДЛЕН, ВЛАДИМИР, ВЛАДИСЛАВ, ВЛАС, ВСЕВОЛОД, ВСЕМИЛ, ВСЕСЛАВ, ВЫШЕСЛАВ, ВЯЧЕСЛАВ,
    ЕВГЕНИЙ, ЕВГРАФ, ЕВДОКИМ, ЕВЛАМПИЙ, ЕВСЕЙ, ЕВСТАФИЙ, ЕВСТИГНЕЙ, ЕГОР, ЕЛИЗАР, ЕЛИСЕЙ, ЕМЕЛЬЯН, ЕПИФАН, ЕРЕМЕЙ, ЕРМИЛ, ЕРМОЛАЙ, ЕРОФЕЙ, ЕФИМ, ЕФРЕМ,
    КИРИЛЛ, ЛАВР, ЛАВРЕНТИЙ, ЛАДИМИР, ЛАЗАРЬ, ЛЕВ, ЛЕОН, ЛЕОНИД, ЛЕОНТИЙ, ЛОНГИН, ЛУКА, ЛУКЬЯН, ЛУЧЕЗАР, ЛЮБИМ, ЛЮБОМИР, ЛЮБОМЫСЛ,
    МАКАР, МАКСИМ, МАКСИМИЛИАН, МАКСИМИЛЬЯН, МАНУИЛ, МАРИАН, МАРК, МАРТЫН, МАРТЬЯН, МАТВЕЙ, МЕФОДИЙ, МЕЧИСЛАВ, МИЛАН, МИЛЕН, МИЛИЙ, МИНА,
    МИР, МИРОН, МИРОСЛАВ, МИТРОФАН, МИХАИЛ, МИХЕЙ, МОДЕСТ, МОИСЕЙ, МОКЕЙ, МСТИСЛАВ,
    НАЗАР, НАРКИС, НАТАН, НАУМ, НЕСТОР, НЕСТЕР, НИКАНДР, НИКАНОР, НИКИТА, НИКИФОР, НИКОДИМ, НИКОЛА, НИКОЛАЙ, НИКОН, НИЛ, НИФОНТ,
    ПАВЕЛ, ПАНКРАТ, ПАНКРАТИЙ, ПАНТЕЛЕЙ, ПАНТЕЛЕЙМОН, ПАНФИЛ, ПАРАМОН, ПАРФЕН, ПАРФЕНИЙ, ПАХОМ, ПЕТР, ПИМЕН, ПЛАТОН, ПОЛИКАРП,
    ПОРФИРИЙ, ПОТАП, ПРОВ, ПРОКЛ, ПРОКОПИЙ, ПРОКОФИЙ, ПРОХОР,
    РАДИМ, РАДИСЛАВ, РАДОВАН, РАТИБОР, РАТМИР, РАФАИЛ, РОДИОН, РОМАН, РОСТИСЛАВ, РУСЛАН, РЮРИК,
    ТАРАС, ТВЕРДИСЛАВ, ТВОРИМИР, ТЕРЕНТИЙ, ТИМОФЕЙ, ТИМУР, ТИТ, ТИХОН, ТРИФОН, ТРОФИМ,
    УЛЬЯН, УСТИН,
    ФАДЕЙ, ФЕДОР, ФЁДОР, ФЕДОСИЙ, ФЕДОСЕЙ, ФЕДОТ, ФЕЛИКС, ФЕОДОСИЙ, ФЕОКТИСТ, ФЕОФАН, ФЕРАПОНТ, ФИЛИМОН, ФИЛИПП, ФИЛИП, ФИРС, ФЛОР, ФЛОРЕНТИН, ФОКА, ФОМА, ФОРТУНАТ, ФОТИЙ, ФРОЛ;

    public static String getRandName() {
        Random r = new Random();
        return values()[r.nextInt(Name.values().length)].toString();
    }
}
