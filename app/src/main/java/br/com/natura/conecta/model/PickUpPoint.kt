package br.com.natura.conecta.model

import androidx.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng
import java.util.UUID

class PickUpPoint(
    var id: String = UUID.randomUUID().toString(),
    var name: String,
    var evaluation: String,
    var position: LatLng,
    @DrawableRes var image: Int,
    @DrawableRes var icon: Int,
    var closeHour: Int,
    var evaluationNumber: Float
)