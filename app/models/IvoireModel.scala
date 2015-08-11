package models

import org.joda.time.DateTime
import play.api.db.slick._
import play.api.libs.json.Json

/**
 * Created by Suamah on 06/08/2015.
 */
object IvoireModel {
  implicit val format = Json.format[Event]
  case class Indicator
  (
    id : Option[Long]=None,
    title:  String,
    description:  String,
    indicateurTypeId: Option[Long],
    countryId: Option[Long],
    comment: Option[String]

    )
  case class IndicatorType
  (
    id : Option[Long]=None,
    description:  String,
    comment: Option[String]

    )


  case class Event
  (
    id : Option[Long]=None,
    title:  String,
    dateEvent:  DateTime,
    dateEndEvent:  DateTime,
    countryId: Option[Long],
    eventTypeId: Option[Long],
    description:  String,
    comment: Option[String]

    )

  case class EventType
  (
    id : Option[Long]=None,
    description:  String,
    comment: Option[String]

    )

  case class Country
  (
    id : Option[Long]=None,
    name:  String,
    abbreviation: String,
    continent: String,
    image: String,
    comment: Option[String]

    )

}
