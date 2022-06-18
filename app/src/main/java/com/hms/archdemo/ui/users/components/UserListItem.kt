package com.hms.archdemo.ui.users.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.hms.archdemo.domian.model.Gender
import com.hms.archdemo.domian.model.User
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserListItem(
    user: User
) {
    Card(elevation = 8.dp,
        modifier = Modifier.fillMaxWidth().padding(16.dp).wrapContentSize(),
        backgroundColor = if (user.gender is Gender.Male) Color.Blue else Color.Magenta

    ) {
        Row(
            modifier = Modifier.wrapContentSize()
        ) {
            GlideImage(
                modifier = Modifier.size(150.dp)
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