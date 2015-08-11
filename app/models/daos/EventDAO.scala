package models.daos

import models.IvoireModel.Event

import scala.concurrent.Future

/**
 * Created by Suamah on 06/08/2015.
 */
class EventDAO  extends DAOSlick with DBTableDefinitions {
  import driver.api._
  import play.api.libs.concurrent.Execution.Implicits.defaultContext

  def all(): Future[List[Event]] = db.run(events.result).map( _.toList)

  def insert(event: Event): Future[Unit] = db.run(events returning events.map(_.id)+= event).map(_ => ())

  def count(): Future[Int] = db.run(events.length.result)

  def find(id : Long):Future[Seq[Event]] = db.run(events.filter(_.id === id).result)


}
