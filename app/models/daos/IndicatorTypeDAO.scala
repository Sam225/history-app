package models.daos

import models.IvoireModel.IndicatorType
import scala.concurrent.Future

/**
 * Created by Suamah on 06/08/2015.
 */
class IndicatorTypeDAO extends DAOSlick with DBTableDefinitions {
  import play.api.libs.concurrent.Execution.Implicits.defaultContext
  import driver.api._

  def all(): Future[List[IndicatorType]] = db.run(indicatorTypes.result).map( _.toList)

  def insert(indicator: IndicatorType): Future[Unit] = db.run(indicatorTypes returning indicatorTypes.map(_.id)+= indicator).map(_ => ())

  def count(): Future[Int] = db.run(indicatorTypes.length.result)
}
