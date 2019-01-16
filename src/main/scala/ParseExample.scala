import net.liftweb.json.DefaultFormats
import net.liftweb.json._

object ParseExample extends App {
  implicit val formats = net.liftweb.json.DefaultFormats
  val jsonStr = "{\"device_uuid\":\"d3ee8ae7ec75ca68ce71657362b34db459abe2ae\",\"os_ver\":\"10.1.1\",\"name\":\"signed_out\",\"device_new\":\"X\",\"custom\":{\"type\":\"invalid_token\"},\"carrier\":\"T-MOBILE USA\",\"model\":\"iPhone 6S Plus\",\"browser\":\"Other\",\"app_ver\":\"2.2.4\",\"Xuuid\":\"5e84d87acfcf617242d696076b6ca83f90539195\",\"device_timezone\":-18000,\"advertising_id\":\"18439F49-97F1-4DBD-8B65-F7CDF5A6A274\",\"country\":\"us\",\"at\":\"X2016-12-19 23:28:56\",\"language\":\"zh\",\"bundle_id\":\"com.creditcards.walletup\",\"user_type\":\"known\",\"session_uuid\":\"\",\"app\":\"X059d52d978d741835375169-bdb5e834-67c1-11e5-0c74-00deb82fd81f\",\"install_uuid\":\"e6de48440808c41e8322055f238802b439803e6d\",\"library_ver\":\"iOSa_4.1.0\",\"type\":\"x\",\"platform\":\"iPhone\",\"jailbroken\":false,\"limit_advertising\":false,\"birth_date\":1478413126,\"customer_ids\":{\"customer_id\":\"422378\"},\"total_session_sec\":26}"
  val json = parse(jsonStr)
  println((json \ "app").extract[String])
}
