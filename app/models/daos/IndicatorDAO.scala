package models.daos

import models.IvoireModel.Indicator

import scala.concurrent.Future

/**
 * Created by Suamah on 06/08/2015.
 */
class IndicatorDAO extends DAOSlick with DBTableDefinitions {

  import driver.api._
  import play.api.libs.concurrent.Execution.Implicits.defaultContext
  def all(): Future[List[Indicator]] = db.run(indicators.result).map( _.toList)

  def insert(indicator: Indicator): Future[Unit] = db.run(indicators returning indicators.map(_.id)+= indicator).map(_ => ())

  def count(): Future[Int] = db.run(indicators.length.result)
}
