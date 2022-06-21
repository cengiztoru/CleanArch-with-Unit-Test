package com.hms.archdemo.ui.users.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserListItem(
    user: User
) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .wrapContentHeight(),
        backgroundColor = if (user.gender is Gender.Male) Color.Blue else Color.Magenta

    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth(CalculateImageWidthFractionAccordingOrientation())
                    .aspectRatio(0.6f)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
                imageModel = user.picture.large,
            )

            Column(modifier = Modifier.padding(start = 16.dp, top = 4.dp)) {
                Text(user.fullName, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))

                Text(user.email)
                Spacer(modifier = Modifier.height(8.dp))

                Text(user.phone)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}

@Composable
private fun CalculateImageWidthFractionAccordingOrientation(): Float {
    val orientation = LocalConfiguration.current.orientation
    return if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        0.15f
    else 0.4f
}
