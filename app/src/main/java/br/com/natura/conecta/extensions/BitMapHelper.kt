package br.com.natura.conecta.extensions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

object BitMapHelper {

    fun imageToBitmap(context: Context, resourceId: Int, width: Int, height: Int): BitmapDescriptor {
        val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, resourceId)
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)

        return BitmapDescriptorFactory.fromBitmap(scaledBitmap)
    }

}