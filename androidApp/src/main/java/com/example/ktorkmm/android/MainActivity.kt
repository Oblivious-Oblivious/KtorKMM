package com.example.ktorkmm.android

import android.annotation.SuppressLint;

import android.os.Bundle;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.padding;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import com.example.ktorkmm.CyberWork;
import com.example.ktorkmm.PlatformRetriever;

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
                    val datamodel = RetrofitDataModel();
//                    val datamodel = KtorDataModel();

                    LaunchedEffect(true) {
                        works = datamodel.getJson().cyberpunk_works;
                    }
                    GreetingView(works, datamodel.library);
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GreetingView(works: List<CyberWork>, library: String) =
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Works in ${library}: ${PlatformRetriever.platform}");
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
