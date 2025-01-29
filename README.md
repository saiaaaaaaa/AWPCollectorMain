# How to use AWPCollectorMain
- Add JitPack in settings.gradle
```
dependencyResolutionManagement {
    /* other existing code */
    repositories {
        /* other existing code */
        maven { url 'https://jitpack.io' }
    }
}
```
- Add dependency in build.gradle
```
implementation 'com.github.saiaaaaaaa:AWPCollectorMain:(version)'
```
- Import the dependency
```
import com.github.saiaaaaaaa.awpcollectormain.AWPCollectorGet;
import com.github.saiaaaaaaa.awpcollectormain.AWPCollectorQuery;
```
