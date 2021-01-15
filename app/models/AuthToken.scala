package models

import java.util.UUID
import play.api.libs.json._
import play.api.libs.functional.syntax._
import org.joda.time.DateTime

/**
 * A token to authenticate a user against an endpoint for a short time period.
 *
 * @param id The unique token ID.
 * @param userID The unique ID of the user the token is associated with.
 * @param expiry The date-time the token expires.
 */
case class AuthToken(
  id: UUID,
  userID: UUID,
  expiry: DateTime)

object AuthToken {
  implicit val writes = new Writes[AuthToken] {
    def writes(auth: AuthToken): JsValue = {
      Json.obj(
        "id" -> auth.id
      )
    }
  }

}

