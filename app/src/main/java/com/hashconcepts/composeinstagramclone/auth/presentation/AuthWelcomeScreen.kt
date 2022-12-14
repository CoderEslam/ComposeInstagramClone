package com.hashconcepts.composeinstagramclone.auth.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hashconcepts.composeinstagramclone.R
import com.hashconcepts.composeinstagramclone.auth.presentation.destinations.LoginScreenDestination
import com.hashconcepts.composeinstagramclone.auth.presentation.destinations.RegisterScreenDestination
import com.hashconcepts.composeinstagramclone.common.components.CustomRaisedButton
import com.hashconcepts.composeinstagramclone.ui.theme.AccentColor
import com.hashconcepts.composeinstagramclone.ui.theme.LightGray
import com.hashconcepts.composeinstagramclone.ui.theme.LineColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * @created 30/07/2022 - 12:01 AM
 * @project ComposeInstagramClone
 * @author  ifechukwu.udorji
 */


@Destination
@Composable
fun AuthWelcomeScreen(
    navigator: DestinationsNavigator
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = null,
            )

            Spacer(modifier = Modifier.height(50.dp))

            AsyncImage(
                model = "https://raw.githubusercontent.com/mustfaibra/Instagraph/master/app/src/main/res/drawable/ed_sheeran.jpg",
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(85.dp),
                placeholder = painterResource(id = R.drawable.profile_placeholder),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Ed Sheeran", style = MaterialTheme.typography.body1, fontSize = 13.sp)

            Spacer(modifier = Modifier.height(12.dp))
            CustomRaisedButton(
                text = "Log in",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {}

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Switch accounts",
                style = MaterialTheme.typography.button,
                color = AccentColor,
                modifier = Modifier.clickable {
                    navigator.navigate(LoginScreenDestination)
                }
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)) {

            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(LineColor))
            
            Spacer(modifier = Modifier.height(18.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
            ) {
                Text(
                    text = "Don't have an account?",
                    style = MaterialTheme.typography.button,
                    color = LightGray,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Sign up",
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.clickable {
                        navigator.navigate(RegisterScreenDestination)
                    }
                )
            }
        }
    }
}