package com.example.app_15_dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_15_dias.data.Datasource
import com.example.app_15_dias.model.Tip
import com.example.compose.FifteenDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FifteenDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FifteenDaysApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FifteenDaysApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { FifteenDaysAppBar()}
    ) { it ->
        LazyVerticalGrid(
            contentPadding = it,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = modifier
        ){
            items(Datasource.tipList){ tip ->
                FifteenDaysCard(tip)
            }
        }
    }
}

@Composable
fun FifteenDaysCard(tip: Tip, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation)),
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .size(475.dp)) {
        Column(
            modifier = Modifier
                .padding(
                    start = dimensionResource(R.dimen.padding_small),
                    top = dimensionResource(R.dimen.padding_small),
                    end = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small)
                )
        ) {
            Text(
                text = stringResource(tip.dayResource),
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_smaller)))

            Text(
                text = stringResource(tip.nameResource),
                style = MaterialTheme.typography.displayMedium
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_smaller)))

            Box(modifier = modifier){
                Image(
                    painter = painterResource(tip.imageResource) ,
                    contentDescription = stringResource(tip.nameResource),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_smaller)))

            Text(
                text = stringResource(tip.textResource),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FifteenDaysAppBar(modifier:Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.cocina_saludable),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
        ,
        modifier = modifier
    )
}

@Preview
@Composable
fun FifteenDaysAppPreview(){
    FifteenDaysAppTheme {
        FifteenDaysApp()
    }
}

