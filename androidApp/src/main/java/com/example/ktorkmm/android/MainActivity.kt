package com.example.ktorkmm.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ktorkmm.JsonGetter

import androidx.compose.runtime.*;
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktorkmm.CyberWork
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var works by remember {
//                        mutableStateOf(listOf<CyberWork>());
                        mutableStateOf(listOf<KotlinCyberWork>());
                    };
                    var library by remember {
                        mutableStateOf("");
                    };
                    val datamodel = RetrofitDataModel();
//                    val datamodel = KtorDataModel();

                    val scope = rememberCoroutineScope();
                    LaunchedEffect(true) {
                        scope.launch {
                            works = datamodel.get_json().cyberpunk_works;
                            library = datamodel.library;
                        }
                    }
                    GreetingView(works, library);
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GreetingView(works: List<KotlinCyberWork>, library: String) {
//fun GreetingView(works: List<CyberWork>, library: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Works in ${library}")
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
}
