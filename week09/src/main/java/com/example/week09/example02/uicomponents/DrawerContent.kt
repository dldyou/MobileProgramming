package com.example.week09.example02.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week09.R

@Composable
fun ColumnScope.DrawerContent() {
    Row {
        Text(
            text = "202211328 윤찬규",
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp
        )
        Image(
            painter = painterResource(id = R.drawable.a),
            contentDescription = "Drawer Image",
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
        )
    }

    Text(
        text = "윤찬규",
        modifier = Modifier.padding(16.dp),
        fontSize = 20.sp
    )
    NavigationDrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Drawer Item 1")
        },
        icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = ""
            )
        },
        onClick = {},
        selected = false
    )
    Spacer(modifier = Modifier.height(8.dp))
}