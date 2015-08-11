package models.daos

import models.IvoireModel.Country
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

/**
 * Created by Suamah on 06/08/2015.
 */
class CountryDAO  extends DAOSlick with DBTableDefinitions{
  import driver.api._

  def all(): Future[List[Country]] = db.run(countrys.result).map(_.toList)
 // def all(): Future[Seq[Country]] = db.run(countrys.result)
  def insert(country: Country): Future[Unit] = db.run(countrys  returning countrys.map(_.id) += country).map(_ => ())
  def count(): Future[Int] = db.run(countrys.length.result)
  //def insert(records: Seq[Record]): Future[Option[Int]] = db.run(this.records ++= records)


}
