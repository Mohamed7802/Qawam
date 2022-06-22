package com.mabdelhafz850.deliverydemoapp.data

import com.mabdelhafz850.deliverydemoapp.pojo.response.RegistrationResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.util.*

import com.mabdelhafz850.deliverydemoapp.pojo.response.*
import com.mabdelhafz850.deliverydemoapp.pojo.response.billmodel.BillModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


class APICreator {


    class OrderStates {
        companion object {
            const val receivedOrder = "received_order"
            const val delivered = "deliverd"
            const val processed = "processed"
            const val arrivedSite = "arrived_site"
            const val makeBill = "make_bill"
            const val cancel = "cancled"
            const val received = "received"
            const val wait = "wait"
        }
    }

    class OrderMessages {
        companion object {
            const val clientReceivedOrderMessage = "تم استلام الطلب من المندوب بنجاح "
            const val driverReceivedOrderMessage = "تم الاستلام "
            const val deliveredMessage = "تم التسليم "
            const val arrivedSiteMessage = "تم الوصول الي الموقع "
            const val PaymentDoneMessage = "تمت عملية الدفع بنجاح  "
            const val cancel = "cancled"
            const val received = "received"
            const val wait = "wait"

            fun makeBillMessage(total_price: Int, tax: Int, price: Int,delivry_price:Int): String = "لقد تم إصدار فاتورة \n" +
                    "سعر الطلب $total_price ج \n" +
                    "وسعر التكلفة $price ج "+
                    "وسعر الدليفري$delivry_price ج "


            fun priceMessage(total_price: Int, tax: Int, price: Int): String =
                "سعر الطلب $total_price ج \n" +
                        "وسيتم خصم ضريبة $tax  ج \n" +
                        "وسعر التكلفة $price  ج "


        }
    }




    private val services: Services
    private val services2: Services


    fun phoneSignUp(
        country: RequestBody,
        phone: RequestBody,
        firebase_token: RequestBody
    ): Observable<PhoneResponse> {
        return services.phoneSignUp(country, phone, firebase_token)
    }


    fun enterUserData(
        user_id: Int?,
        first_name: RequestBody,
        last_name: RequestBody,
        passwords: RequestBody,
        image: MultipartBody.Part?,
        phone: RequestBody,
        email: RequestBody,
        gender_id: Int,
        longitude: Double,
        latitude: Double,
        firebase_token: RequestBody
        // RX Java
    ): Observable<RegistrationResponse> {
        return services.enterUserData(
            user_id,
            first_name,
            last_name,
            passwords,
            image,
            phone,
            email,
            gender_id,
            longitude,
            latitude,
            firebase_token
        )

    }


    fun editUserProfile(
        user_token: RequestBody,
        first_name: RequestBody,
        last_name: RequestBody,
        passwords: RequestBody,
        image: MultipartBody.Part?,
        phone: RequestBody?,
        email: RequestBody?,
        gender_id: Int
    ): Observable<EditProfileResponse> {
        return services.editUserProfile(
            user_token,
            first_name,
            last_name,
            passwords,
            image,
            phone,
            email,
            gender_id
        )
    }


    fun logout(
        user_token: RequestBody
    ): Observable<GeneralResponse> {
        return services.logout(user_token)
    }


    fun showBanks():
            Observable<ShowBanksResponse> {
        return services.showBanks()
    }


    fun userDataCounts(user_token: String): Observable<UserDataCountsResponse> {
        return services.userDataCounts(user_token)
    }


    fun showUseConditions(user_token: String): Observable<ConditionsResponse> {
        return services.showUseConditions(user_token)
    }


    fun showPolicy(user_token: String): Observable<ShowPolicyResponse> {
        return services.showPolicy(user_token)
    }


    fun cancelOrder(
        user_token: String,
        request_id: Int,
        cancel_reason: String,
        driver_id: Int?
    ): Observable<GeneralResponse> {
        return services.cancelOffer(user_token, request_id, cancel_reason, driver_id)
    }


    fun accept_cancelRequest(
        user_token: String,
        request_id: Int,
        action: String
    ): Observable<GeneralResponse> {
        return services.accept_cancelRequest(user_token, request_id, action)
    }


    fun getMyOrders(user_token: String, type: String): Observable<MyOrdersResponse> {
        return services.getMyOrders(user_token, type)
    }


    fun deliverOrder(user_token: String, request_id: Int): Observable<GeneralResponse> {
        return services.deliverOrder(user_token, request_id)
    }


    fun orderReceived(user_token: String, request_id: Int): Observable<GeneralResponse> {
        return services.orderReceived(user_token, request_id)
    }


    fun rateUser(
        user_token: RequestBody,
        user_id: Int,
        rate_number: Double,
        comment: RequestBody,
        request_id: Int
    ): Observable<GeneralResponse> {
        return services.rateUser(user_token, user_id, rate_number, comment, request_id)
    }


    fun arrivedSite(user_token: String, request_id: Int): Observable<GeneralResponse> {
        return services.arrivedSite(user_token, request_id)
    }


    fun cancelOffer(
        user_token: String,
        request_id: Int,
        cancel_reason: String
    ): Observable<GeneralResponse> {
        return services.cancelOffer(user_token, request_id, cancel_reason)
    }

    fun makeOrder(
        user_token: RequestBody,
        shope_id: Int?,
        receive_place: RequestBody,
        receiving_latitude: Double?,
        receiving_longitude: Double?,
        delivery_place: RequestBody,
        delivery_latitude: Double,
        delivery_longitude: Double,
        delivery_time: Date,
        description: RequestBody,
        image: MultipartBody.Part?,
        copon: RequestBody,
        payment_id: Int,
        menu: RequestBody?,
        total_price: Double
    ): Observable<MakeOrderResponse> {
        return services.makeOrder(
            user_token, shope_id,
            receive_place,
            receiving_latitude,
            receiving_longitude,
            delivery_place,
            delivery_latitude,
            delivery_longitude,
            delivery_time,
            description,
            image,
            copon,
            payment_id,
            total_price
        )
    }

    fun showShopById(user_token: String, shop_id: Int): Observable<ShowShopByIdResponse> {
        return services.showShopById(user_token, shop_id)
    }

    fun showAllNearShops(user_token: String): Observable<ShowAllNearShopsAndCategoriesResponse> {
        return services.showAllNearShops(user_token)
    }

    fun showAllNearByShops(location: String, category: String): Observable<Places_Response> {
        return services2.showAllNearByShops(
            "AIzaSyCBYpxNhbkA1UBK6c87zAdzFn7S1-6yea8",
            location, "10000", category
        )
    }

    fun showAllNearByShopsByCat(location: String, category: String): Observable<Places_Response> {
        return services2.showAllNearByShops(
            "AIzaSyCBYpxNhbkA1UBK6c87zAdzFn7S1-6yea8",
            location, "10000", category
        )
    }

    fun showAllNearShops(
        user_token: String,
        catgory: String
    ): Observable<ShowAllNearShopsAndCategoriesResponse> {
        return services.showAllNearShops(user_token, catgory)
    }

    fun showProductTypes(
        user_token: String,
        product_id: Int
    ): Observable<ShowProduceTypesResponse> {
        return services.showProductTypes(user_token, product_id)
    }


    fun sentMessage(
        user_token: RequestBody,
        user_id: Int?,
        message: RequestBody?,
        image: MultipartBody.Part?,
        request_id: Int,
        voice: MultipartBody.Part?

    ): Call<SentMessageResponse> {
        return services.sentMessage(user_token, user_id, message, image, request_id, voice)
    }

    fun showMessages(
        user_token: String,
        user_id: Int,
        request_id: Int
    ): Observable<ShowMessagesResponse> {
        return services.showMessages(user_token, user_id, request_id)
    }

    fun showUserOfOrder(user_token: String, user_id: Int): Observable<ShowUserOfOrderResponse> {
        return services.showUserOfOrder(user_token, user_id)
    }

    fun showShops(user_token: String): Observable<ShowShopsResponse> {
        return services.showShops(user_token)
    }

    fun sentShakway(
        user_token: RequestBody,
        user_id: RequestBody,
        order_id: RequestBody,
        comment: RequestBody?,
        reason: RequestBody,
        image: MultipartBody.Part?,
        notes: RequestBody?,
        details: RequestBody?, answers: RequestBody
    ): Observable<GeneralResponse> {
        return services.sentShakway(
            user_token, user_id, order_id, comment, reason, image, notes, details, answers
        )
    }

    fun showMyCoupons(user_token: String): Observable<MyCouponsResponse> {
        return services.showMyCoupons(user_token)
    }

    fun addMyCoupon(user_token: RequestBody, copon: RequestBody): Observable<GeneralResponse> {
        return services.addMyCoupon(user_token, copon)
    }

    fun showOffers(user_token: String): Observable<ShowOffersResponse> {
        return services.showOffers(user_token, "user")
    }


    fun showOffersDel(user_token: String): Observable<DeliveryOffers_Response> {
        return services.showOffersDel(user_token, "driver")
    }

    fun userAcceptOffer(user_token: String, offer_id: Int): Observable<BillResponse> {
        return services.userAcceptOffer(user_token, offer_id.toString())
    }

    fun showRating(user_token: String): Observable<CommentsResponse> {
        return services.showRating(user_token)
    }

    //for other   /?user_token&user_id
    fun showRatingByUserId(user_token: String, user_id: Int): Observable<UserRateResponse> {
        return services.showRatingByUserId(user_token, user_id)
    }

    fun showProblems(user_token: String): Observable<ProblemsResponse> {
        return services.showProblems(user_token)
    }

    fun joinAsCaptain(
        user_id: Int?,
        first_name: RequestBody,
        last_name: RequestBody,
        nationality: RequestBody,
        card_number: RequestBody,
        gender_id: Int,
        image: MultipartBody.Part?,
        passwords: RequestBody,
        driving_license_image: MultipartBody.Part?,
        front_vehical_image: MultipartBody.Part?,
        car_license_image: MultipartBody.Part?,
        phone: RequestBody,
        email: RequestBody,
        firebase_token: RequestBody,
        longitude: Double,
        latitude: Double,
        bank_account: Int,
        bank: Int,
        apple_account: Int,
        account_number: RequestBody?
    ): Observable<Driver_Response> {
        return services.joinAsCaptain(
            user_id,
            first_name,
            last_name,
            nationality,
            card_number,
            gender_id,
            image,
            passwords,
            driving_license_image,
            front_vehical_image,
            car_license_image,
            phone,
            email,
            firebase_token,
            longitude,
            latitude,
            bank_account,
            bank,
            apple_account,
            account_number
        )
    }

    fun showComplainReasons(user_token: String): Observable<ShowComplainReasonsResponse> {
        return services.showComplainReasons(user_token)
    }

    fun myAccounts(user_token: String): Observable<MyAccountsResponse> {
        return services.myAccounts(user_token)
    }

    fun editAccount(
        user_token: RequestBody,
        account_id: Int,
        name: RequestBody,
        address: RequestBody,
        account_number: RequestBody?,
        country: RequestBody?,
        phone: RequestBody?
    ): Observable<GeneralResponse> {
        return services.editAccount(
            user_token,
            account_id,
            name,
            address,
            account_number,
            country,
            phone
        )
    }

    fun turnOnNotifications(user_token: String): Observable<TurnNotificationResponse> {
        return services.turnOnNotifications(user_token)
    }

    fun changeAgent(user_token: String, request_id: Int): Observable<GeneralResponse> {
        return services.changeAgent(user_token, request_id)
    }

    fun orderById(user_token: String, request_id: Int): Observable<ShowOrderResponse> {
        return services.orderById(user_token, request_id)
    }

    fun getShopOrders(user_token: String, shop_id: String): Observable<Shop_Orders_Response> {
        return services.showShopOrders(user_token, shop_id)
    }

    fun addShopAgent(user_token: String, shop_id: String): Observable<GeneralResponse> {
        return services.addShopAgent(user_token, shop_id)
    }


    fun showComplianceById(user_token: String, id: String): Observable<ProblemDetailsResponse> {
        return services.showComplianceById(user_token, id)
    }

    fun showComplainQuestions(user_token: String): Observable<ShowComplainQuestionsResponse> {
        return services.showComplainQuestions(user_token)
    }


    fun makeOffer(
        user_token: RequestBody,
        request_id: RequestBody,
        price: Int,
        lang: RequestBody
    ): Call<GeneralResponse> {
        return services.makeOffer(user_token, request_id, price, lang)

    }


    fun getTotalDelivery(user_token: String): Observable<Total_Delivery_Response> {
        return services.getTotalDelivery(user_token)
    }

    fun makeBill(
        user_token: RequestBody,
        request_id: Int?,
        price: Int,
        total_price: Int,
        image: MultipartBody.Part?
    ): Observable<BillPriceResponse> {
        return services.makeBill(user_token, request_id, price, total_price, image)
    }

    fun updateLocation(
        user_token: RequestBody,
        longitude: Double,
        latitude: Double
    ): Observable<GeneralResponse> {
        return services.updateLocation(user_token, longitude, latitude)
    }

    fun deleteNotification(user_token: String, id: Int): Call<GeneralResponse> {
        return services.deleteNotification(user_token, id)
    }

    fun showUserTax(user_token: String): Observable<UserTaxResponse> {
        return services.showUserTax(user_token)
    }

    fun checkEmail(email: String): Observable<CheckEmailResponse> {
        return services.checkEmail(email)
    }

    fun notNow(state: Int): Observable<NotNowResponse> {
        return services.notNow(state)
    }

    fun showBillByRequestId(user_token: String, request_id: Int)
            : Observable<BillModel> = services.showBillByRequestId(user_token, request_id)

    fun paymentRequest(
        user_token: String,
        merchantTransactionId: Int,
        amount: Int,
        email: String
    ): Observable<PaymentResponse> =
        services.paymentRequest(user_token, merchantTransactionId, amount, email)

    fun paymentStatus(
        user_token: String,
        requestCheckoutId: String
    ): Observable<PaymentStateResponse> = services.paymentStatus(user_token, requestCheckoutId)


    fun userReceivedOrder(
        user_token: String,
        request_id: Int,
        driver_id: Int
    ):
            Observable<GeneralResponse> =
        services.userReceivedOrder(user_token, request_id, driver_id)

    fun clientSayPayment(
        user_token: String,
        request_id: Int,
        driver_id: Int
    ):
            Observable<GeneralResponse> =
        services.clientSayPayment(user_token, request_id, driver_id)


}