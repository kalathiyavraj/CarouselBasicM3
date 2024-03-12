package com.screens.data;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.firebase.messaging.ServiceStarter;
import com.screens.R;
import com.screens.model.CardViewImg;
import com.screens.model.Image;
import com.screens.model.Inbox;
import com.screens.model.MusicAlbum;
import com.screens.model.MusicSong;
import com.screens.model.News;
import com.screens.model.People;
import com.screens.model.ShopCategory;
import com.screens.model.ShopProduct;
import com.screens.model.Social;
import com.screens.utils.MaterialColor;
import com.screens.utils.Tools;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private static Random r = new Random();

    public static int randInt(int i) {
        return r.nextInt(i + 0 + 1) + 0;
    }

    public static List<String> getStringsShort(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getResources().getStringArray(R.array.strings_short)) {
            arrayList.add(str);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<String> getStringsMedium(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getResources().getStringArray(R.array.strings_medium)) {
            arrayList.add(str);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<String> getFullDate(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getResources().getStringArray(R.array.full_date)) {
            arrayList.add(str);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<Integer> getAllImages(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.all_images);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            arrayList.add(Integer.valueOf(obtainTypedArray.getResourceId(i, -1)));
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<Integer> getNatureImages(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.sample_images);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            arrayList.add(Integer.valueOf(obtainTypedArray.getResourceId(i, -1)));
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<String> getStringsMonth(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getResources().getStringArray(R.array.month)) {
            arrayList.add(str);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<CardViewImg> getCardImageData(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        List<Integer> natureImages = getNatureImages(context);
        List<String> stringsShort = getStringsShort(context);
        List<String> stringsShort2 = getStringsShort(context);
        for (int i2 = 0; i2 < i; i2++) {
            CardViewImg cardViewImg = new CardViewImg();
            cardViewImg.image = natureImages.get(getRandomIndex(natureImages.size())).intValue();
            cardViewImg.title = stringsShort.get(getRandomIndex(stringsShort.size()));
            cardViewImg.subtitle = stringsShort2.get(getRandomIndex(stringsShort2.size()));
            arrayList.add(cardViewImg);
        }
        return arrayList;
    }

    public static List<People> getPeopleData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.people_images);
        String[] stringArray = context.getResources().getStringArray(R.array.people_names);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            People people = new People();
            people.image = obtainTypedArray.getResourceId(i, -1);
            people.name = stringArray[i];
            people.email = Tools.getEmailFromName(people.name);
            people.imageDrw = context.getResources().getDrawable(people.image);
            arrayList.add(people);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<Social> getSocialData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.social_images);
        String[] stringArray = context.getResources().getStringArray(R.array.social_names);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Social social = new Social();
            social.image = obtainTypedArray.getResourceId(i, -1);
            social.name = stringArray[i];
            social.imageDrw = context.getResources().getDrawable(social.image);
            arrayList.add(social);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<Inbox> getInboxData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.people_images);
        String[] stringArray = context.getResources().getStringArray(R.array.people_names);
        String[] stringArray2 = context.getResources().getStringArray(R.array.general_date);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Inbox inbox = new Inbox();
            inbox.image = Integer.valueOf(obtainTypedArray.getResourceId(i, -1));
            inbox.from = stringArray[i];
            inbox.email = Tools.getEmailFromName(inbox.from);
            inbox.message = context.getResources().getString(R.string.lorem_ipsum);
            inbox.date = stringArray2[randInt(stringArray2.length - 1)];
            inbox.imageDrw = context.getResources().getDrawable(inbox.image.intValue());
            arrayList.add(inbox);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<Image> getImageDate(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.sample_images);
        String[] stringArray = context.getResources().getStringArray(R.array.sample_images_name);
        String[] stringArray2 = context.getResources().getStringArray(R.array.general_date);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.brief = stringArray2[randInt(stringArray2.length - 1)];
            image.counter = r.nextBoolean() ? Integer.valueOf(randInt(ServiceStarter.ERROR_UNKNOWN)) : null;
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<Image> getImageDate2(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.sample_images);
        String[] stringArray = context.getResources().getStringArray(R.array.sample_images_name);
        String[] stringArray2 = context.getResources().getStringArray(R.array.general_date);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.brief = stringArray2[randInt(stringArray2.length - 1)];
            image.counter = Integer.valueOf(randInt(ServiceStarter.ERROR_UNKNOWN));
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<ShopCategory> getShoppingCategory(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.shop_category_icon);
        TypedArray obtainTypedArray2 = context.getResources().obtainTypedArray(R.array.shop_category_bg);
        String[] stringArray = context.getResources().getStringArray(R.array.shop_category_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.shop_category_brief);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            ShopCategory shopCategory = new ShopCategory();
            shopCategory.image = obtainTypedArray.getResourceId(i, -1);
            shopCategory.image_bg = obtainTypedArray2.getResourceId(i, -1);
            shopCategory.title = stringArray[i];
            shopCategory.brief = stringArray2[i];
            shopCategory.imageDrw = AppCompatResources.getDrawable(context, shopCategory.image);
            arrayList.add(shopCategory);
        }
        return arrayList;
    }

    public static List<ShopProduct> getShoppingProduct(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.shop_product_image);
        String[] stringArray = context.getResources().getStringArray(R.array.shop_product_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.shop_product_price);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            ShopProduct shopProduct = new ShopProduct();
            shopProduct.image = obtainTypedArray.getResourceId(i, -1);
            shopProduct.title = stringArray[i];
            shopProduct.price = stringArray2[i];
            shopProduct.imageDrw = context.getResources().getDrawable(shopProduct.image);
            arrayList.add(shopProduct);
        }
        return arrayList;
    }

    public static List<MusicSong> getMusicSong(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.album_cover);
        String[] stringArray = context.getResources().getStringArray(R.array.song_name);
        String[] stringArray2 = context.getResources().getStringArray(R.array.album_name);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            MusicSong musicSong = new MusicSong();
            musicSong.image = obtainTypedArray.getResourceId(i, -1);
            musicSong.title = stringArray[i];
            musicSong.brief = stringArray2[i];
            musicSong.imageDrw = context.getResources().getDrawable(musicSong.image);
            arrayList.add(musicSong);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static List<MusicAlbum> getMusicAlbum(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.album_cover);
        String[] stringArray = context.getResources().getStringArray(R.array.album_name);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            MusicAlbum musicAlbum = new MusicAlbum();
            musicAlbum.image = obtainTypedArray.getResourceId(i, -1);
            musicAlbum.name = stringArray[i];
            musicAlbum.brief = getRandomIndex(15) + " MusicSong (s)";
            musicAlbum.color = MaterialColor.getColor(context, musicAlbum.name, i);
            musicAlbum.imageDrw = context.getResources().getDrawable(musicAlbum.image);
            arrayList.add(musicAlbum);
        }
        return arrayList;
    }

    public static List<News> getNewsData(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        List<Integer> allImages = getAllImages(context);
        List<String> stringsMedium = getStringsMedium(context);
        List<String> fullDate = getFullDate(context);
        String[] stringArray = context.getResources().getStringArray(R.array.news_category);
        for (int i2 = 0; i2 < i; i2++) {
            News news = new News();
            news.image = allImages.get(getRandomIndex(allImages.size())).intValue();
            news.title = stringsMedium.get(getRandomIndex(stringsMedium.size()));
            news.subtitle = stringArray[getRandomIndex(stringArray.length)];
            news.date = fullDate.get(getRandomIndex(fullDate.size()));
            arrayList.add(news);
        }
        return arrayList;
    }

    public static List<Image> getPhotoInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.photo_info_icon);
        String[] stringArray = context.getResources().getStringArray(R.array.photo_info_name);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        return arrayList;
    }

    public static List<Image> getIntroData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.photo_illustration);
        String[] stringArray = context.getResources().getStringArray(R.array.strings_wizard_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.strings_wizard_content);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.brief = stringArray2[i];
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        return arrayList;
    }

    public static List<Image> getIntroOrangeData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.photo_illustration_orange);
        String[] stringArray = context.getResources().getStringArray(R.array.strings_wizard_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.strings_wizard_content);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.brief = stringArray2[i];
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        return arrayList;
    }

    public static List<Image> getIntroHealthData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.photo_illustration_health);
        String[] stringArray = context.getResources().getStringArray(R.array.strings_wizard_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.strings_wizard_content);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.brief = stringArray2[i];
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        return arrayList;
    }

    public static List<Image> getIntroShopData(Context context) {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.photo_illustration_shop);
        String[] stringArray = context.getResources().getStringArray(R.array.strings_wizard_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.strings_wizard_content);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            Image image = new Image();
            image.image = obtainTypedArray.getResourceId(i, -1);
            image.name = stringArray[i];
            image.brief = stringArray2[i];
            image.imageDrw = context.getResources().getDrawable(image.image);
            arrayList.add(image);
        }
        return arrayList;
    }

    public static String formatTime(long j) {
        SimpleDateFormat simpleDateFormat;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(System.currentTimeMillis());
        if (instance.get(1) != instance2.get(1)) {
            simpleDateFormat = new SimpleDateFormat("MMM yyyy", Locale.US);
        } else if (instance.get(6) == instance2.get(6)) {
            simpleDateFormat = new SimpleDateFormat("h:mm a", Locale.US);
        } else {
            simpleDateFormat = new SimpleDateFormat("MMM d", Locale.US);
        }
        return simpleDateFormat.format(Long.valueOf(j));
    }

    private static int getRandomIndex(int i) {
        return r.nextInt(i - 1);
    }
}
