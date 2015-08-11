
import models.daos._
import org.joda.time.format.DateTimeFormat

import scala.concurrent.Await
import scala.concurrent.duration.Duration

import models.IvoireModel._



import play.api.{Play, Application, GlobalSettings}

/**
 * Created by Suamah on 06/08/2015.
 */

  object Global extends GlobalSettings {

    override def onStart(app: Application) {

       InitialData.seed_EventType()
       InitialData.seed_IndicatorType()
       InitialData.seed_Country()
       InitialData.seed_Event()
    }

  }


  object InitialData {
    private def countryDao = new CountryDAO
    private def eventDao = new EventDAO
    private def eventTypeDao = new EventTypeDAO
    private def indicatorTypeDao = new IndicatorTypeDAO
    private def indicatorDao = new IndicatorDAO


    def seed_Country() = {
      val storedRecords = Await.result(countryDao.count(), Duration.Inf)

      if (storedRecords == 0) {
        val cou = List(
          ("COTE_D_IVOIRE", "CI", "AFRIQUE", "NULL", None),
          ("GHANA", "GH", "AFRIQUE", "NULL", None),
          ("AFRIQUE_DU_SUD", "AF", "AFRIQUE", "NULL", None),
          ("BENIN", "BN", "AFRIQUE", "NULL", None),
          ("TOGO", "TG", "AFRIQUE", "NULL", None),
          ("CAMEROUN", "CM", "AFRIQUE", "NULL", None),
          ("CONGO", "CG", "AFRIQUE", "NULL", None),
          ("BURKINA_FASO", "BF", "AFRIQUE", "NULL", None)
        )
       cou.map(
           c => Await.result( countryDao.insert (Country(name = c._1, abbreviation = c._2, continent = c._3, image = c._4, comment = c._5)), Duration.Inf)
        )
      }


      }



    def seed_EventType() ={

      val storedRecords = Await.result(eventTypeDao.count(), Duration.Inf)

      if (storedRecords == 0) {
        val liste = List(
          ("HISTOIRE", None),
          ("POLITIQUE", None),
          ("GEOGRAPHIQUE", None),
          ("ECONOMIQUE", None),
          ("SOCIALE", None),
          ("SANTE", None),
          ("CULTUREL", None)
        )
        liste.map(
          c => Await.result( eventTypeDao.insert (EventType(description = c._1, comment = c._2)), Duration.Inf)
        )
      }

    }

    def seed_IndicatorType() {

          val storedRecords = Await.result(indicatorTypeDao.count(), Duration.Inf)

          if (storedRecords == 0) {
            val liste = List(
              ("IND_POLITIQUE", None),
              ("IND_GEOGRAPHIQUE", None),
              ("IND_ECONOMIQUE", None),
              ("IND_SOCIALE", None),
              ("IND_SANTE", None)
            )
            liste.map(
              c => Await.result( indicatorTypeDao.insert (IndicatorType(description = c._1, comment = c._2)), Duration.Inf)
            )
          }


      }


    val df = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")

    def seed_Event() {

          val storedRecords = Await.result(eventDao.count(), Duration.Inf)

          if (storedRecords == 0) {
            val liste =  List(
              ("TEST", df.parseDateTime("26/10/2010 00:00:00"), df.parseDateTime("26/10/2010 00:00:00"), 1L, 1L,"TEST", None),
              ("HISTOIRE", df.parseDateTime("26/10/2010 00:00:00"), df.parseDateTime("26/10/2010 00:00:00"), 1L, 1L,"TEST", None),
              ("ELECTIONS_PRESIDENTIELLES_2000", df.parseDateTime("22/10/2010 00:00:00"), df.parseDateTime("24/10/2010 00:00:00"), 2L, 1L,"élections présidentielles en Côte d'voire mettant aux prises principalement Laurent Gbagbo au Général Guéi", None),
              ("RESULTATS_PRESIDENTIELLES_2000", df.parseDateTime("24/10/2010 00:00:00"), df.parseDateTime("24/10/2010 00:00:00"), 2L, 1L,"Guéi fait arrêter Honoré Guié et s'autoproclame vainqueur", None),
              ("INVESTITURE_2000", df.parseDateTime("26/10/2010 00:00:00"), df.parseDateTime("26/10/2010 00:00:00"), 2L, 1L,"prestation de serment de Laurent Gbagbo (LG)", None),
              ("EVENEMENTS_POST_ELECTORAUX_2000", df.parseDateTime("26/10/2010 00:00:00"), df.parseDateTime("26/10/2010 00:00:00"), 2L, 1L,"Découverte du charnier de Yopougon", None),
              ("MANIFESTATION_RDR", df.parseDateTime("4/12/2010 00:00:00"), df.parseDateTime("5/12/2010 00:00:00"), 2L, 1L,"manifestations au Nord pour le rejet de la canditature de Ouattara aux législatives, les fonctionnaires sont chassés de plusieurs localités du Nord dont Kong où il paraît que le drapeau burkinabé a flotté sur des mâts", None),
              ("TENTATIVE_COUP_D_ETAT", df.parseDateTime("4/01/2011 00:00:00"), df.parseDateTime("5/01/2011 00:00:00"), 2L,1L, "tentative de coup d état . la radio et la télévision occupées, puis reprises par les forces loyalistes FANCI", None),
              ("TEST1", df.parseDateTime("22/10/2012 00:00:00"), df.parseDateTime("22/10/2012 00:00:00"), 2L, 1L,"TEST1", None),
              ("TEST2", df.parseDateTime("22/10/2011 00:00:00"), df.parseDateTime("22/10/2011 00:00:00"), 2L,1L, "TEST222", None),
              ("TEST32", df.parseDateTime("22/10/2011 00:00:00"), df.parseDateTime("22/10/2011 00:00:00"), 3L,1L, "TEST222", None),
              ("TEST211", df.parseDateTime("22/10/2011 00:00:00"), df.parseDateTime("22/10/2011 00:00:00"), 3L,1L, "TEST1111", None),
              ("TES3EE", df.parseDateTime("22/10/2011 00:00:00"), df.parseDateTime("22/10/2011 00:00:00"), 4L, 1L,"TEST2", None),
              ("TESTREDD", df.parseDateTime("22/11/2013 00:00:00"), df.parseDateTime("22/11/2013 00:00:00"), 5L,1L, "TEST3", None),
              ("TEST4", df.parseDateTime("22/12/2014 00:00:00"), df.parseDateTime("22/12/2014 00:00:00"), 6L, 1L,"TEST4", None),
              ("TEST5", df.parseDateTime("22/10/2015 00:00:00"), df.parseDateTime("22/10/2015 00:00:00"), 7L,1L, "TEST5", None)

            )
            liste.map(
              c => Await.result( eventDao.insert ( Event(
                title = c._1,
                dateEvent = c._2,
                dateEndEvent = c._3,
                countryId = Some(c._4),
                eventTypeId = Some(c._5),
                description = c._6.toUpperCase,
                comment = c._7)
              )
                , Duration.Inf)
            )
          }

    }




}
