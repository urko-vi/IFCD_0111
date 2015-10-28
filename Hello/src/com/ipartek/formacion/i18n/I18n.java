package com.ipartek.formacion.i18n;

import java.util.Locale;

/**
 * Clase con utilidades para los idiomas
 * 
 * @author java
 *
 */
public class I18n {
  public static String getBrowserLocale(Locale localeBrowser) {
    String locale = Idioma.CASTELLANO.getLocale();
    System.out.println(locale);
    if (localeBrowser != null) {
      // es euskera

      String localeEuskera = Idioma.EUSKERA.getLenguaje();

      if (localeBrowser.getLanguage().equalsIgnoreCase(localeEuskera)) {
        locale = Idioma.EUSKERA.getLocale();
      } else {
        // si es ingles
        if (localeBrowser.getLanguage().equalsIgnoreCase(Idioma.INGLES.getLenguaje())) {
          locale = Idioma.INGLES.getLocale();
        }
      }
    }

    return locale;
  }
}
