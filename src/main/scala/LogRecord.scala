case class Custom
(
  `type`: Option[String],
  destination: Option[String],
  source: Option[String],
  user_state: Option[String],
  posts_viewed: Option[String],
  logged_in: Option[String],
  `Campaign ID`: Option[String],
  `Push Notifications Enabled`: Option[String],
  `Schema Version - Server`: Option[String],
  `Schema Version - Client`: Option[String],
  `Creative Displayed`: Option[String],
  `App Context`: Option[String],
  `Creative ID`: Option[String],
  `Creative Type`: Option[String],
  presentation: Option[String],
  verification_sent: Option[String],
  method: Option[String],
  discover_added: Option[String],
  `deal `: Option[String]
  //discover_added/method/cards_added/jcb_added/banks_added/american_added/mastercard_added/visa_added, card_selected/user_state/network_selected, source/logged_in/version, user_state/card_selected/network_selected, status_code, user_state/source, network_selected/card_selected/user_state, network_selected/user_state, accept, viewed_video/user_state, url/error, refresh_token/status_code/error_description/raw_data, resend_code/method/wrong_verification_code, Campaign ID/Schema Version - Server/Schema Version - Client/Creative ID/Creative Type/Action, error/url, newsletter/accept, destination/source, post_id/user_state, logged_in/method, method/searched_card/searched_bank/searched_online_merchant/searched_merchant/search_term/searched_location, reason, card, method, has_viewed_inquiries/has_viewed_inquiry_detail/has_viewed_personal/has_viewed_records/has_viewed_account_type_list/has_viewed_record_detail/time_spent/has_viewed_account_detail, new_user/verification_sent/method, tracker, time_spent, message/reason, wrong_verification_code/resend_code/method, logged_in, source/user_state, method/error_message, method/verification_sent, method/resend_code/new_user/wrong_verification_code, source/destination/user_state, better_card/better_card_displayed, ampAB/Schema Version - Server/Schema Version - Client/ampAction/ampCampaign/ampCampaignId, resend_code/method/wrong_verification_code/new_user, user_state/viewed_video, raw_data/status_code/refresh_token, version/logged_in/source, bank_connected, user_state/method, method/user_state, ampAB/Schema Version - Server/Schema Version - Client/ampAction/ampCampaign/type/ampCampaignId, user_state/card_selected, error, type, deal /user_state, additional_card, source/destination, card_displayed, refresh_token/status_code/raw_data, new_user/method/verification_sent, accept_permission, logged_in/source, subscribe, source, Campaign ID/Creative ID/Creative Type/Schema Version - Server, env, user_state/network_selected, deal/user_state, user_state, changed_recipe, source/logged_in, error_message/method, high_card_amount/mid_card_amount/low_card_amount, accept_permission/user_state)
)
//{
//  def defaults = copy(
//    `type`   = `type` orElse None,
//    destination = destination orElse None,
//    source = source orElse None,
//    user_state = user_state orElse None
//  )
//}

case class CustomerId
(
  customer_id: String
)

case class LogRecord
(
  advertising_id: Option[String],
  app: String,
  app_ver: Option[String],
  at: String,
  birth_date: Option[Int],
  browser: Option[String],
  bundle_id: Option[String],
  carrier: Option[String],
  country: Option[String],
  var custom_attrs: Option[String],
  customer_ids: Option[CustomerId],
  device_new: Boolean,
  device_timezone: Option[Int],
  device_uuid: String,
  has_push: Option[Boolean],
  install_uuid: Option[String],
  jailbroken: Option[Boolean],
  language: Option[String],
  library_ver: String,
  limit_advertising: Option[Boolean],
  model: Option[String],
  name: Option[String],
  nth: Option[Short],
  os_ver: Option[String],
  platform: Option[String],
  session_uuid: Option[String],
  `type`: String,
  user_type: String,
  uuid: String,
  // Fields not in sample on HOUS channel
  google_advertising_id: Option[String],
  sec_since_last_session: Option[String],
  clv_change: Option[String],
  city_name: Option[String],
  acquire_campaign: Option[String],
  clv_total: Option[String],
  data_conn: Option[String],
  region: Option[String],
  screen_flow: Option[List[String]],
  //var screen_flow_out: Option[String],
  closed_at: Option[String],
  total_session_sec: Option[String],
  acquire_source: Option[String],
  var file_date: Option[String],
  var file_subdir: Option[String],
  var file_hour: Option[String]
)

