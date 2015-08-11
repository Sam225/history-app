package models.daos

import models.IvoireModel.EventType

import scala.concurrent.Future

/**
 * Created by Suamah on 06/08/2015.
 */
class EventTypeDAO extends DAOSlick with DBTableDefinitions{
  import driver.api._
  import play.api.libs.concurrent.Execution.Implicits.defaultContext
  def all(): Future[List[EventType]] = db.run(eventTypes.result).map(_.toList)

  def insert(eventType: EventType): Future[Unit] = db.run(eventTypes returning eventTypes.map(_.id)+= eventType).map(_ => ())
  def count(): Future[Int] = db.run(eventTypes.length.result)


}


