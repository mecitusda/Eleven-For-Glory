class Utility {
  static String setLogo(String teamName) {
    switch(teamName) {
      case 'FenerBahçe':
        return 'assets/fb.png';
      case 'Alanyaspor':
        return 'assets/alanyaspor.png';
      case 'AnkaraGücü':
        return 'assets/ankaragucu.png';
      case 'Antalyaspor':
        return 'assets/antalya.png';
      case 'İstanbul Başakşehir':
        return 'assets/basaksehir.png';
      case 'Beşiktaş':
        return 'assets/besiktas2.png';
      case 'Denizlispor':
        return 'assets/denizli.png';
      case 'Göztepe':
        return 'assets/goztepe.png';
      case 'Gençlerbirliği':
        return 'assets/genclerb.png';
      case 'Gaziantep FK':
        return 'assets/gfk.png';
      case 'Galatasaray':
        return 'assets/gs.png';
      case 'Hayatspor':
        return 'Hatayspor.png';
      case 'Kasımpaşa':
        return 'assets/kasimpasa.png';
      case 'Kayserispor':
        return 'assets/kayseri.png';
      case 'Konyaspor':
        return 'assets/konya.png';
      case 'Malatyaspor':
        return 'assets/Malatyaspor.png';
      case 'Rizespor':
        return 'assets/rizespor.png';
      case 'TrabzonSpor':
        return 'assets/ts2.png';
    }
    return '';
  }
}