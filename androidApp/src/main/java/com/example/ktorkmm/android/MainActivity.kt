package com.example.ktorkmm.android

import android.annotation.SuppressLint;

import android.os.Bundle;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.padding;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import com.example.ktorkmm.CommonDataModel
import com.example.ktorkmm.CyberWork;
import com.example.ktorkmm.Direction
import com.example.ktorkmm.PlatformClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    var works by remember {
                        mutableStateOf(listOf<CyberWork>());
                    };
//                    val datamodel = RetrofitDataModel();
                    val datamodel = KtorDataModel();

                    LaunchedEffect(true) {
                        works = datamodel.getJson().cyberpunk_works;
                    }
//                    MainView(works, datamodel.library);
                    ExpectActualView();
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainView(works: List<CyberWork>, library: String) =
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Works in ${library}");
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
            );
        },
        content = {
            LazyColumn {
                items(works) {
                    Text(
                        text = "${it.name} (${it.year}), ${it.creator}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(8.dp),
                    );
                    Divider(color = Color.Gray, thickness = 1.dp);
                }
            }
        }
    );
@Composable
fun ExpectActualView() =
    Column {
        Text(
            text = "class: ${PlatformClass().name()}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
        );
        Text(
            text = "function: ${CommonDataModel.platformFunctionCommon()}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
        );
        Text(
            text = "property: ${CommonDataModel.platformPropertyCommon}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
        );
        Text(
            text = "object: ${CommonDataModel.platformObjectCommon.name}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
        );
        Text(
            text = "enum: ${CommonDataModel.direction(Direction.NORTH)}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
        );
    }
