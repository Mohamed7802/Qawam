package com.mabdelhafz850.deliverydemoapp.data

import com.mabdelhafz850.deliverydemoapp.pojo.response.RegistrationResponse
import java.util.*
import com.mabdelhafz850.deliverydemoapp.pojo.response.*
import com.mabdelhafz850.deliverydemoapp.pojo.response.billmodel.BillModel
import retrofit2.http.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call


interface Services {

    //profile
    @Multipart
    @POST("phone_verify")
    fun phoneSignUp(
        @Part("country") country: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("firebase_token") firebase_token: RequestBody
    ): Observable<PhoneResponse>


    @Multipart
    @POST("regesteration")
    fun enterUserData(
        @Part("user_id") user_id: Int?,
        @Part("first_name") first_name: RequestBody,
        @Part("last_name") last_name: RequestBody,
        @Part("passwords") passwords: RequestBody,
        @Part image: MultipartBody.Part?,
        @Part("phone") phone: RequestBody,
        @Part("email") email: RequestBody,
        @Part("gender_id") gender_id: Int,
        @Part("longitude") longitude: Double,
        @Part("latitude") latitude: Double,
        @Part("firebase_token") firebase_token: RequestBody
    ): Observable<RegistrationResponse>


    @Multipart
    @POST("update_location")
    fun updateLocation(
        @Part("user_token") user_token: RequestBody,
        @Part("longitude") longitude: Double,
        @Part("latitude") latitude: Double
    ): Observable<GeneralResponse>

    @Multipart
    @POST("edit_userProfile")
    fun editUserProfile(
        @Part("user_token") user_token: RequestBody,
        @Part("first_name") first_name: RequestBody,
        @Part("last_name") last_name: RequestBody,
        @Part("passwords") passwords: RequestBody,
        @Part image: MultipartBody.Part?,
        @Part("phone") phone: RequestBody?,
        @Part("email") email: RequestBody?,
        @Part("gender_id") gender_id: Int
    ): Observable<EditProfileResponse>


    @Multipart
    @POST("logout")
    fun logout(
        @Part("user_token") user_token: RequestBody
    ): Observable<GeneralResponse>

    //            @Part("user_id") user_id: Int?


    @Multipart
    @POST("driver_regesteration")
    fun joinAsCaptain(
        @Part("user_id") user_id: Int?,
        @Part("first_name") first_name: RequestBody,
        @Part("last_name") last_name: RequestBody,
        @Part("nationality") nationality: RequestBody,
        @Part("card_number") card_number: RequestBody,
        @Part("gender_id") gender_id: Int,
        @Part image: MultipartBody.Part?,
        @Part("passwords") passwords: RequestBody,
        @Part driving_license_image: MultipartBody.Part?,
        @Part front_vehical_image: MultipartBody.Part?,
        @Part car_license_image: MultipartBody.Part?,
        @Part("phone") phone: RequestBody,
        @Part("email") email: RequestBody,
        @Part("firebase_token") firebase_token: RequestBody,
        @Part("longitude") longitude: Double,
        @Part("latitude") latitude: Double,
        @Part("bank_account") bank_account: Int,
        @Part("bank") bank: Int,
        @Part("apple_account") apple_account: Int,
        @Part("account_number") account_number: RequestBody?
    ): Observable<Driver_Response>

    @GET("show_banks")
    fun showBanks(): Observable<ShowBanksResponse>

    @GET("user_Datacounts")
    fun userDataCounts(@Query("user_token") user_token: String): Observable<UserDataCountsResponse>

    @GET("about_us")
    fun aboutUs(@Query("user_token") user_token: String): Observable<AboutUsResponse>

    @GET("check_email")
    fun checkEmail(@Query("email") email: String): Observable<CheckEmailResponse>

    @GET("not_now")
    fun notNow(@Query("state") state: Int): Observable<NotNowResponse>

    //?user_token for me
    @GET("show_rating")
    fun showRating(@Query("user_token") user_token: String): Observable<CommentsResponse>

    //for other   /?user_token&user_id
    @GET("show_ratingby_userid")
    fun showRatingByUserId(
        @Query("user_token") user_token: String,
        @Query("user_id") user_id: Int
    ): Observable<UserRateResponse>

    @GET("show_compliance")
    fun showProblems(@Query("user_token") user_token: String): Observable<ProblemsResponse>

    //notifications
    @GET("show_Notifications")
    fun showNotifications(
        @Query("user_token") user_token: String,
        @Query("type") type: String,
        @Query("lang") lang: String
    ): Observable<NotificationsResponse>

    //orders
    @GET("user_cancel_order")
    fun cancelOffer(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int,
        @Query("cancel_reason") cancel_reason: String,
        @Query("driver_id") driver_id: Int?
    ): Observable<GeneralResponse>

    @GET("accept_cancelRequest")
    fun accept_cancelRequest(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int,
        @Query("action") action: String
    ): Observable<GeneralResponse>

    @GET("user_active_requestes")
    fun getMyOrders(
        @Query("user_token") user_token: String,
        @Query("type") type: String
    ): Observable<MyOrdersResponse>

    @GET("order_byid")
    fun orderById(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int
    ): Observable<ShowOrderResponse>

    @GET("order_deliverd")
    fun deliverOrder(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int
    ): Observable<GeneralResponse>

    @GET("order_received")
    fun orderReceived(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int
    ): Observable<GeneralResponse>

    @GET("arrived_site")
    fun arrivedSite(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int
    ): Observable<GeneralResponse>

    @GET("user_received_order")
    fun userReceivedOrder(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int,
        @Query("driver_id") driver_id: Int
    ): Observable<GeneralResponse>

    @Multipart
    @POST("make_compliance")
    fun sentShakway(
        @Part("user_token") user_token: RequestBody,
        @Part("user_id") user_id: RequestBody,
        @Part("order_id") order_id: RequestBody,
        @Part("comment") comment: RequestBody?,
        @Part("reason") reason: RequestBody,
        @Part image: MultipartBody.Part?,
        @Part("notes") notes: RequestBody?,
        @Part("details") details: RequestBody?,
        @Part("answers") answers: RequestBody
    ): Observable<GeneralResponse>

    @GET("Withdraw_Fromorder")
    fun cancelOffer(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int,
        @Query("cancel_reason") cancel_reason: String
    ): Observable<GeneralResponse>

    // @Headers({"Content-Type: application/json;charset=UTF-8"})
    //    @Headers("Content-Type: application/json;charset=UTF-8")
    //    @JvmSuppressWildcards


    @Multipart
    @POST("make_order")
    //    fun makeOrder(@Body makeOrderRequest: MakeOrderRequest): Observable<MakeOrderResponse>
    fun makeOrder(
        @Part("user_token") user_token: RequestBody,
        @Part("shope_id") shope_id: Int?,
        @Part("receive_place") receive_place: RequestBody,
        @Part("receiving_latitude") receiving_latitude: Double?,
        @Part("receiving_longitude") receiving_longitude: Double?,
        @Part("delivery_place") delivery_place: RequestBody,
        @Part("delivery_latitude") delivery_latitude: Double,
        @Part("delivery_longitude") delivery_longitude: Double,
        @Part("delivery_time") delivery_time: Date,
        @Part("description") description: RequestBody,
        @Part image: MultipartBody.Part?,
        @Part("copon") copon: RequestBody,
        @Part("payment_id") payment_id: Int,
        @Part("total_price") total_price: Double

    ): Observable<MakeOrderResponse>

    @GET("show_shopbyid")
    fun showShopById(
        @Query("user_token") user_token: String,
        @Query("shop_id") shop_id: Int
    ): Observable<ShowShopByIdResponse>

    @GET("show_product_type")
    fun showProductTypes(
        @Query("user_token") user_token: String,
        @Query("product_id") product_id: Int
    ): Observable<ShowProduceTypesResponse>

    @GET("show_allnearshopes")
    fun showAllNearShops(@Query("user_token") user_token: String): Observable<ShowAllNearShopsAndCategoriesResponse>

    @GET("json")
    fun showAllNearByShops(
        @Query("key") key: String,
        @Query("location") location: String,
        @Query("radius") radius: String,
        @Query("type") type: String
    ): Observable<Places_Response>


    @GET("show_allnearshopes")
    fun showAllNearShops(
        @Query("user_token") user_token: String,
        @Query("category") category: String
    ): Observable<ShowAllNearShopsAndCategoriesResponse>


    @GET("show_shopes")
    fun showShops(@Query("user_token") user_token: String): Observable<ShowShopsResponse>

    //chat
    @Multipart
    @POST("sentmessage")
    fun sentMessage(
        //@Body sentMessageRequest: SentMessageRequest
        @Part("user_token") user_token: RequestBody,
        @Part("user_id") user_id: Int?,
        @Part("message") message: RequestBody?,
        @Part image: MultipartBody.Part?,
        @Part("request_id") request_id: Int, @Part voice: MultipartBody.Part?
    ): Call<SentMessageResponse>

    @GET("showmessage")
    fun showMessages(
        @Query("user_token") user_token: String,
        @Query("user_id") user_id: Int,
        @Query("order") order: Int
    ): Observable<ShowMessagesResponse>

    @GET("show_userOf_order")
    fun showUserOfOrder(
        @Query("user_token") user_token: String,
        @Query("user_id") user_id: Int
    ): Observable<ShowUserOfOrderResponse>

    ///show_myCopons?user_token
    @GET("show_myCopons")
    fun showMyCoupons(@Query("user_token") user_token: String): Observable<MyCouponsResponse>

    @Multipart
    @POST("add_mycopon")
    fun addMyCoupon(
        @Part("user_token") user_token: RequestBody,
        @Part("copon") copon: RequestBody
    ): Observable<GeneralResponse>


    //default
    //offers
    @GET("show_offers")
    fun showOffers(
        @Query("user_token") user_token: String,
        @Query("type") type: String
    ): Observable<ShowOffersResponse>

    @GET("show_offers")
    fun showOffersDel(
        @Query("user_token") user_token: String,
        @Query("type") type: String
    ): Observable<DeliveryOffers_Response>

    @GET("user_accept_offer")
    fun userAcceptOffer(
        @Query("user_token") user_token: String,
        @Query("offer_id") offer_id: String
    ): Observable<BillResponse>

    @GET("show_complain_reasons")
    fun showComplainReasons(@Query("user_token") user_token: String): Observable<ShowComplainReasonsResponse>

    //my_accounts
    @GET("my_accounts")
    fun myAccounts(@Query("user_token") user_token: String): Observable<MyAccountsResponse>

    @GET("show_use_conditions")
    fun showUseConditions(@Query("user_token") user_token: String): Observable<ConditionsResponse>


    @GET("show_policy")
    fun showPolicy(@Query("user_token") user_token: String): Observable<ShowPolicyResponse>


    /*
    user_token
    name
    address
    account_number
    country
    phone
    */


    @Multipart
    @POST("edit_account")
    fun editAccount(
        @Part("user_token") user_token: RequestBody,
        @Part("account_id") account_id: Int,
        @Part("name") name: RequestBody,
        @Part("address") address: RequestBody,
        @Part("account_number") account_number: RequestBody?,
        @Part("country") country: RequestBody?,
        @Part("phone") phone: RequestBody?
    ): Observable<GeneralResponse>


    @Multipart
    @POST("driver_rateUser")
    fun rateUser(
        @Part("user_token") user_token: RequestBody,
        @Part("user_id") user_id: Int,
        @Part("rate_number") rate_number: Double,
        @Part("comment") comment: RequestBody,
        @Part("request_id") request_id: Int
    ): Observable<GeneralResponse>


    @GET("show_usertax")
    fun showUserTax(@Query("user_token") user_token: String): Observable<UserTaxResponse>

    @GET("turn_ONNotifications")
    fun turnOnNotifications(@Query("user_token") user_token: String): Observable<TurnNotificationResponse>

    @GET("change_agent")
    fun changeAgent(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int
    ): Observable<GeneralResponse>

    @GET("add_me_shopAgent")
    fun addShopAgent(
        @Query("user_token") user_token: String, @Query("shope_id") shop_id: String
    ): Observable<GeneralResponse>

    @GET("shop_orders")
    fun showShopOrders(
        @Query("user_token") user_token: String, @Query("shope_id") shop_id: String
    ): Observable<Shop_Orders_Response>


    @GET("show_compliancebyid")
    fun showComplianceById(
        @Query("user_token") user_token: String, @Query("id") id: String
    ): Observable<ProblemDetailsResponse>

    @GET("show_complain_questions")
    fun showComplainQuestions(@Query("user_token") user_token: String): Observable<ShowComplainQuestionsResponse>

    @Multipart
    @POST("make_offer")
    fun makeOffer(
        @Part("user_token") user_token: RequestBody,
        @Part("request_id") shop_id: RequestBody,
        @Part("price") price: Int,
        @Part("lang") lang: RequestBody
    ): Call<GeneralResponse>

    @GET("delivery_total")
    fun getTotalDelivery(@Query("user_token") user_token: String): Observable<Total_Delivery_Response>

    @Multipart
    @POST("make_bill")
    fun makeBill(
        @Part("user_token") user_token: RequestBody,
        @Part("request_id") request_id: Int?,
        @Part("request_price") request_price: Int,
        @Part("total_price") total_price: Int,
        @Part image: MultipartBody.Part?
    ): Observable<BillPriceResponse>

    @GET("delete_Notification")
    fun deleteNotification(
        @Query("user_token") user_token: String,
        @Query("id") id: Int
    ): Call<GeneralResponse>

    @GET("show_bill")
    fun showBillByRequestId(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int
    )
            : Observable<BillModel>

    @GET("payment_request")
    fun paymentRequest(
        @Query("user_token") user_token: String,
        @Query("merchantTransactionId") merchantTransactionId: Int,
        @Query("amount") amount: Int,
        @Query("email") email: String
    ): Observable<PaymentResponse>

    @GET("payment_status")
    fun paymentStatus(
        @Query("user_token") user_token: String,
        @Query("id") requestCheckoutId: String
    ): Observable<PaymentStateResponse>


    @GET("client_say_payment")
    fun clientSayPayment(
        @Query("user_token") user_token: String,
        @Query("request_id") request_id: Int,
        @Query("driver_id") driver_id: Int
    ): Observable<GeneralResponse>


}